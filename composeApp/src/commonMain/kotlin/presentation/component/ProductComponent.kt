package presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import domain.model.Product
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product,
    onItemClick: (Int) -> Unit
) {
    Card(
        modifier = modifier.padding(4.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight().padding(8.dp).clickable {
                    onItemClick(product.id)
                }) {
            KamelImage(
                modifier = Modifier.fillMaxWidth().height(120.dp),
                resource = asyncPainterResource(product.image),
                contentDescription = product.name
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                style = MaterialTheme.typography.subtitle2,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}

@Composable
fun ProductDetailCard(
    modifier: Modifier = Modifier,
    product: Product,
) {
    Card(
        modifier = modifier.padding(16.dp).fillMaxWidth(),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight().padding(8.dp)
            ) {
                KamelImage(
                    resource = asyncPainterResource(product.image),
                    contentDescription = product.name,
                    modifier = Modifier.fillMaxWidth().height(250.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = product.name, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = product.desc.orEmpty(), style = MaterialTheme.typography.body1)
            }
        }

    }
}
