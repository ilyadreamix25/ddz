package ua.ilyadreamix.ddz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.ilyadreamix.ddz.BuildConfig
import ua.ilyadreamix.ddz.R
import ua.ilyadreamix.ddz.theme.DDZTheme

@Composable
fun BoxScope.DDZDevWatermark() {
    if (BuildConfig.DEBUG) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.Black)
        ) {
            Text(
                text = stringResource(
                    R.string.dev_version,
                    BuildConfig.VERSION_NAME
                ),
                style = LocalTextStyle.current.copy(
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
internal fun DDZDevWatermarkPreview() {
    DDZTheme {
        Box {
            DDZDevWatermark()
        }
    }
}
