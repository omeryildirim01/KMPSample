package presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    typeOfIndicator: ProgressIndicatorType = ProgressIndicatorType.CIRCULAR
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = contentAlignment) {
        when(typeOfIndicator) {
            ProgressIndicatorType.CIRCULAR -> CircularProgressIndicator()
            ProgressIndicatorType.LINEAR -> LinearProgressIndicator()
        }
    }
}

enum class ProgressIndicatorType {
    CIRCULAR,
    LINEAR
}
