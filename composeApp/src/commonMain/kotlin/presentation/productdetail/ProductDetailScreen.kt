package presentation.productdetail

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.Navigator
import presentation.component.ProductDetailCard
import presentation.component.ProgressIndicator
import presentation.component.ShowError
import presentation.component.TopBar

@Composable
fun ProductDetailScreen(
    navigator: Navigator,
    viewModel: ProductDetailViewModel,
    id: Int
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(uiState) {
        viewModel.getProduct(id)
    }
    Scaffold(
        topBar = {
            TopBar(
                navigator = navigator,
                backImage = Icons.Default.ArrowBack,
                title = "Product Details")
        }
    ) {
        when (uiState.value) {
            is ProductDetailScreenState.Error -> ShowError((uiState.value as ProductDetailScreenState.Error).error)
            ProductDetailScreenState.Loading -> ProgressIndicator()
            is ProductDetailScreenState.ProductDetail -> (uiState.value as ProductDetailScreenState.ProductDetail).data?.let { product ->
                ProductDetailCard(product = product)
            }
        }
    }
}