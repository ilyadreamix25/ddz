package ua.ilyadreamix.ddz.grades

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ua.ilyadreamix.idxcomponents.IDXSmallIconButton
import ua.ilyadreamix.idxcomponents.IDXTopBar
import ua.ilyadreamix.ddz.components.DDZAppLogo

@Composable
fun GradesScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            IDXTopBar(
                modifier = Modifier.statusBarsPadding(),
                endButtons = {
                    IDXSmallIconButton(imageVector = Icons.Rounded.Menu)
                },
                appLogo = {
                    DDZAppLogo()
                }
            )
        },
    ) { insets ->
        GradesList(modifier = Modifier.padding(insets)) { gradeInfo ->
            navController.navigate(gradeInfo.grade.toString())
        }
    }
}
