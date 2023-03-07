package ua.ilyadreamix.ddz.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import ua.ilyadreamix.ddz.R
import ua.ilyadreamix.ddz.etc.DDZDimen
import ua.ilyadreamix.ddz.theme.DDZTheme

@Composable
fun DDZTopBar(
    modifier: Modifier = Modifier,
    startButtons: (@Composable RowScope.() -> Unit)? = null,
    endButtons: (@Composable RowScope.() -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = DDZDimen.TopAppBarPadding,
                start = DDZDimen.ScreenSidesPadding,
                end = DDZDimen.ScreenSidesPadding
            )
    ) {
        if (startButtons != null) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    DDZDimen.TopAppBarElementsSpacing,
                    Alignment.CenterHorizontally
                ),
                modifier = Modifier.padding(end = DDZDimen.ScreenSidesPadding),
                content = startButtons
            )
        }

        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h5
                .copy(
                    platformStyle = @Suppress("Deprecation") PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
        )
        
        Spacer(modifier = Modifier.weight(1f))

        if (endButtons != null) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    DDZDimen.TopAppBarElementsSpacing,
                    Alignment.CenterHorizontally
                ),
                content = endButtons
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun HMTopBarPreview() {
    DDZTheme {
        DDZTopBar(
            startButtons = { DDZSmallIconButton(Icons.Rounded.ArrowBack) },
            endButtons = {
                DDZSmallIconButton(Icons.Rounded.Menu)
                DDZSmallIconButton(Icons.Rounded.Refresh)
            }
        )
    }
}
