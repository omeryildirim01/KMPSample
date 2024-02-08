package presentation.productlist

import domain.model.Product
import domain.usecase.GetProductListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import util.RequestResult

class ProductListViewModel(
    private val useCase: GetProductListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProductListScreenState>(ProductListScreenState.Loading)
    val uiState: StateFlow<ProductListScreenState> = _uiState.asStateFlow()
    init {
        getProducts()
    }

    private fun getProducts() = useCase().onEach {  result ->
        when(result) {
            is RequestResult.Loading -> {
                _uiState.update {
                    ProductListScreenState.Loading
                }
            }
            is RequestResult.Error -> {
                _uiState.update {
                    ProductListScreenState.Error(error = result.message)
                }
            }
            is RequestResult.Success -> {
                _uiState.update {
                    ProductListScreenState.ShowData(data = result.data.orEmpty())
                }
            }
        }
    }.launchIn(viewModelScope)

}

sealed class ProductListScreenState {
    data object Loading : ProductListScreenState()
    data class ShowData(val data: List<Product>) : ProductListScreenState()
    data class Error(val error: String) : ProductListScreenState()
}