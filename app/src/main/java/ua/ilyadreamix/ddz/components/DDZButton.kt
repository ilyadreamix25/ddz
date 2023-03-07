package ua.ilyadreamix.ddz.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import ua.ilyadreamix.ddz.etc.DDZDimen
import ua.ilyadreamix.ddz.etc.changeAlphaOnPress

@Composable
fun DDZSmallIconButton(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
    onClick: () -> Unit = {}
) {
    Icon(
        imageVector = imageVector,
        contentDescription = null,
        modifier = modifier
            .size(DDZDimen.SmallButtonSize)
            .changeAlphaOnPress(onClick = onClick),
        tint = tint
    )
}
