package presentation.nav

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import presentation.productdetail.ProductDetailScreen
import presentation.productdetail.ProductDetailViewModel
import presentation.productlist.ProductListScreen
import presentation.productlist.ProductListViewModel

@Composable
fun AppNavigation() {

    val navigator = rememberNavigator()

    NavHost(navigator = navigator, initialRoute = NavigationRoute.ProductList.route) {
        scene(route = NavigationRoute.ProductList.route) {
            val viewModel: ProductListViewModel = koinViewModel(ProductListViewModel::class)
            ProductListScreen(viewModel) {
                navigator.navigate(NavigationRoute.ProductDetail.getRoute(it))
            }
        }

        scene(route = NavigationRoute.ProductDetail.route) {
            val id = it.path.filter { p -> p.isDigit() }
            val viewModel: ProductDetailViewModel = koinViewModel(ProductDetailViewModel::class)
            viewModel.getProduct(id.toInt())
            ProductDetailScreen(navigator, viewModel)
        }
    }

}

sealed class NavigationRoute(val route: String) {
    data object ProductList : NavigationRoute("/product_list")

    data object ProductDetail : NavigationRoute("/product_detail/{id}") {
        fun getRoute(id: Int) = "/product_detail/${id}"
    }
}