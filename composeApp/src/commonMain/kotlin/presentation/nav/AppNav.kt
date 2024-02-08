package presentation.nav

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import presentation.productlist.ProductListScreen
import presentation.productlist.ProductListViewModel

@Composable
fun AppNavigation() {

    val navigator = rememberNavigator()

    NavHost(navigator = navigator, initialRoute = NavigationRoute.ProductList.route) {
        scene(route = NavigationRoute.ProductList.route) {
            val viewModel: ProductListViewModel = koinViewModel(ProductListViewModel::class)
            ProductListScreen(viewModel)
        }
    }

}

sealed class NavigationRoute(val route: String) {
    data object ProductList: NavigationRoute("/product_list")
}