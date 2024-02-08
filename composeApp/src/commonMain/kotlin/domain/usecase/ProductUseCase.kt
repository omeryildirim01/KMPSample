package domain.usecase

import domain.model.Product
import domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import util.RequestResult

class GetProductListUseCase: KoinComponent {
    private val productRepository: ProductRepository by inject()

    operator fun invoke() = flow<RequestResult<List<Product>>> {
        emit(RequestResult.Loading())
        emit(RequestResult.Success(data = productRepository.getProducts()))
    }.catch {
        emit(RequestResult.Error(message = it.message.orEmpty()))
    }.flowOn(Dispatchers.IO)

}