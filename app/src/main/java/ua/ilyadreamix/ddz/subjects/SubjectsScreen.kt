package ua.ilyadreamix.ddz.subjects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ua.ilyadreamix.idxcomponents.IDXSmallIconButton
import ua.ilyadreamix.idxcomponents.IDXTopBar
import ua.ilyadreamix.ddz.components.DDZAppLogo
import ua.ilyadreamix.ddz.etc.ResponseState

@Composable
fun SubjectsScreen(
    grade: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val subjectsViewModel = viewModel<SubjectsViewModel>()
    val subjectsState by subjectsViewModel.subjectsState

    LaunchedEffect(Unit) {
        subjectsViewModel.updateSubjects(grade)
    }

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
                },
                startButtons = {
                    IDXSmallIconButton(imageVector = Icons.Rounded.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) { insets ->
        // TODO: Full screen
        Box(modifier = Modifier.padding(insets)) {
            Text(
                text = when (subjectsState.state) {
                    ResponseState.Loading -> "Loading..."
                    ResponseState.Success -> "Success! (${subjectsState.data!!.size} subjects)"
                    ResponseState.Error -> "Error!"
                    else -> "Idle"
                }
            )
        }
    }
}
