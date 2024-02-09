package domain.usecase

import domain.model.Product
import domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.component.KoinComponent
import util.RequestResult

class GetProductListUseCase(
    private val repository: ProductRepository
) : KoinComponent {
    operator fun invoke() = flow<RequestResult<List<Product>>> {
        emit(RequestResult.Loading())
        emit(RequestResult.Success(data = repository.getProducts()))
    }.catch {
        emit(RequestResult.Error(message = it.message.orEmpty()))
    }.flowOn(Dispatchers.IO)

}

class GetProductUseCase(
    private val repository: ProductRepository
) : KoinComponent {

    operator fun invoke(id: Int) = flow<RequestResult<Product>> {
        emit(RequestResult.Loading())
        emit(RequestResult.Success(data = repository.getProduct(productId = id)))
    }.catch {
        emit(RequestResult.Error(message = it.message.orEmpty()))
    }.flowOn(Dispatchers.IO)
}