
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.KoinContext
import presentation.nav.AppNavigation

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    KoinContext {
        PreComposeApp {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}