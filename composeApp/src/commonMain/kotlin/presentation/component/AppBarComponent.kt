package presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun TopBar(
    contentColor:Color = Color.Black,
    backgroundColor:Color = Color.White,
    titleStyle:TextStyle  = MaterialTheme.typography.h5,
    titleTextColor: Color = Color.Black,
    navigator: Navigator? = null,
    backImage: ImageVector? = null,
    title: String
) {
    TopAppBar(contentColor = contentColor, backgroundColor = backgroundColor) {
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            backImage?.let {img ->
                Image(
                    imageVector = img,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navigator?.goBack()
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            Text(
                text = title,
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )
        }
    }
}