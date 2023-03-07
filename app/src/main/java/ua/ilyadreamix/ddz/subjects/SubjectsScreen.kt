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
import ua.ilyadreamix.ddz.components.DDZSmallIconButton
import ua.ilyadreamix.ddz.components.DDZTopBar

@Composable
fun SubjectsScreen(
    grade: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val subjectsViewModel = viewModel<SubjectsViewModel>()
    val subjects by subjectsViewModel.subjects

    LaunchedEffect(Unit) {
        subjectsViewModel.updateSubjects(grade)
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            DDZTopBar(
                modifier = Modifier.statusBarsPadding(),
                endButtons = {
                    DDZSmallIconButton(imageVector = Icons.Rounded.Menu)
                },
                startButtons = {
                    DDZSmallIconButton(imageVector = Icons.Rounded.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) { insets ->
        // TODO: Full screen
        Box(modifier = Modifier.padding(insets)) {
            if (subjects.isEmpty()) Text(text = "Loading...")
            else Text(text = "Success!")
        }
    }
}
