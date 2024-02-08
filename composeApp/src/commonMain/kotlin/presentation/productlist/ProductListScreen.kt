package presentation.productlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle

@Composable
fun ProductListScreen(viewModel: ProductListViewModel) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    when(uiState.value) {
        is ProductListScreenState.Error -> {
            Box( modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text((uiState.value as ProductListScreenState.Error).error)
            }
        }
        ProductListScreenState.Loading -> {
            Box( modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("LOADING")
            }

        }
        is ProductListScreenState.ShowData -> {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items((uiState.value as ProductListScreenState.ShowData).data) {
                    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(16.dp)) {
                        KamelImage(
                            modifier = Modifier.fillMaxWidth().height(250.dp),
                            resource = asyncPainterResource(it.image),
                            contentDescription = it.name
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.subtitle2,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2
                        )
                    }
                }
            }

        }
    }
}