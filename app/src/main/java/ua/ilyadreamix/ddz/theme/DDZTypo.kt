package ua.ilyadreamix.ddz.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ua.ilyadreamix.ddz.R

@Suppress("PrivatePropertyName")
private val DDZFonts = FontFamily(
    Font(resId = R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(resId = R.font.montserrat_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_black, weight = FontWeight.Black),
    Font(resId = R.font.montserrat_black_italic, weight = FontWeight.Black, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(resId = R.font.nontserrat_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_bold_extra, weight = FontWeight.ExtraBold),
    Font(resId = R.font.montserrat_bold_italic_extra, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_light, weight = FontWeight.Light),
    Font(resId = R.font.montserrat_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_light_extra, weight = FontWeight.ExtraLight),
    Font(resId = R.font.montserrat_light_italic_extra, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_medium, weight = FontWeight.Medium),
    Font(resId = R.font.montserrat_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_semi_bold, weight = FontWeight.SemiBold),
    Font(resId = R.font.montserrat_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(resId = R.font.montserrat_thin, weight = FontWeight.Thin),
    Font(resId = R.font.montserrat_thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic)
)

val DDZTypo = Typography(
    defaultFontFamily = DDZFonts,
    h4 = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Medium
    ),
    h5 = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    body1 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    body2 = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    button = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    caption = TextStyle(
        fontSize = 16.sp
    ),
    overline = TextStyle(
        fontSize = 16.sp
    )
)
