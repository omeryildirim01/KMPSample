package presentation.productdetail

import domain.model.Product
import domain.usecase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import util.RequestResult

class ProductDetailViewModel(
    private val useCase: GetProductUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ProductDetailScreenState>(ProductDetailScreenState.Loading)
    val uiState: StateFlow<ProductDetailScreenState> = _uiState.asStateFlow()

    fun getProduct(productId: Int) = useCase(productId).onEach { result ->
        when(result) {
            is RequestResult.Error -> _uiState.update {
                ProductDetailScreenState.Error(result.message)
            }
            is RequestResult.Loading ->  _uiState.update {
                ProductDetailScreenState.Loading
            }
            is RequestResult.Success ->  _uiState.update {
                ProductDetailScreenState.ProductDetail(result.data)
            }
        }
    }.launchIn(viewModelScope)
}

sealed class ProductDetailScreenState {
    data object Loading : ProductDetailScreenState()
    data class ProductDetail(val data: Product?) : ProductDetailScreenState()
    data class Error(val error: String) : ProductDetailScreenState()
}