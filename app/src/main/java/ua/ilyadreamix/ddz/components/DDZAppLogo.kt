package ua.ilyadreamix.ddz.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import ua.ilyadreamix.ddz.R

@Composable
fun DDZAppLogo(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.app_name),
        modifier = modifier,
        style = MaterialTheme.typography.h5.copy(
            platformStyle = @Suppress("Deprecation") PlatformTextStyle(
                includeFontPadding = false
            )
        )
    )
}
