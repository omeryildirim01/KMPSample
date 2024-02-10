package presentation.productlist

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import presentation.component.ProductCard
import presentation.component.ProgressIndicator
import presentation.component.ShowError
import presentation.component.TopBar

@Composable
fun ProductListScreen(viewModel: ProductListViewModel, onItemClick: (Int) -> Unit) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopBar(
                title = "Product List",
            )
        }
    ) {
        when (uiState.value) {
            is ProductListScreenState.Error -> ShowError((uiState.value as ProductListScreenState.Error).error)
            ProductListScreenState.Loading -> ProgressIndicator()
            is ProductListScreenState.ShowData -> {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items((uiState.value as ProductListScreenState.ShowData).data) {
                        ProductCard(product = it, onItemClick = onItemClick)
                    }
                }

            }
        }
    }

}