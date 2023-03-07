package ua.ilyadreamix.ddz.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalElevationOverlay
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Suppress("PrivatePropertyName")
private val DDZDarkColors = darkColors(
    primary = DDZPurple,
    onPrimary = Color.White,
    secondary = DDZYellow,
    background = Color.Black,
    onBackground = Color.White
)

@Suppress("PrivatePropertyName")
private val DDZLightColors = lightColors(
    primary = DDZPurple,
    onPrimary = Color.White,
    secondary = DDZYellow,
    background = Color.White,
    onBackground = Color.Black
)


@Composable
fun DDZTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    val context = LocalContext.current
    val isDarkTheme = isSystemInDarkTheme()

    if (!view.isInEditMode) {
        SideEffect {
            val window = (context as Activity).window
            WindowCompat.setDecorFitsSystemWindows(window, false)
            WindowCompat.getInsetsController(window, view)
                .apply {
                    isAppearanceLightStatusBars = !isDarkTheme
                    isAppearanceLightNavigationBars = !isDarkTheme
                }
        }
    }

    MaterialTheme(
        colors = if (isDarkTheme) DDZDarkColors else DDZLightColors,
        typography = DDZTypo,
        content = {
            CompositionLocalProvider(
                LocalElevationOverlay provides null,
                LocalRippleTheme provides DDZNoRippleTheme,
                content = content
            )
        }
    )
}

private object DDZNoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha() = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}
