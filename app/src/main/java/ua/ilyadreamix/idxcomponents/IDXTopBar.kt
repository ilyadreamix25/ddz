package ua.ilyadreamix.idxcomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun IDXTopBar(
    modifier: Modifier = Modifier,
    startButtons: (@Composable RowScope.() -> Unit)? = null,
    endButtons: (@Composable RowScope.() -> Unit)? = null,
    appLogo: (@Composable RowScope.() -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = IDXDimen.TopAppBarPadding,
                start = IDXDimen.ScreenSidesPadding,
                end = IDXDimen.ScreenSidesPadding
            )
    ) {
        if (startButtons != null) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    IDXDimen.TopAppBarElementsSpacing,
                    Alignment.CenterHorizontally
                ),
                modifier = Modifier.padding(end = IDXDimen.ScreenSidesPadding),
                content = startButtons
            )
        }

        if (appLogo != null) {
            appLogo()
        }
        
        Spacer(modifier = Modifier.weight(1f))

        if (endButtons != null) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    IDXDimen.TopAppBarElementsSpacing,
                    Alignment.CenterHorizontally
                ),
                content = endButtons
            )
        }
    }
}
