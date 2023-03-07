package ua.ilyadreamix.ddz.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.ilyadreamix.ddz.grades.GradesScreen
import ua.ilyadreamix.ddz.subjects.SubjectsScreen

@Composable
fun DDZNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = DDZRoutes.Grades.route
    ) {
        composable(DDZRoutes.Grades.route) {
            GradesScreen(navController = navController)
        }

        composable(DDZRoutes.Subjects.route, arguments = DDZRoutes.Subjects.arguments!!) {
            val grade = it.arguments?.getInt("class")!!
            SubjectsScreen(grade = grade, navController = navController)
        }

        composable(DDZRoutes.Lessons.route, arguments = DDZRoutes.Lessons.arguments!!) {
            // ...
        }

        composable(DDZRoutes.Exercises.route, arguments = DDZRoutes.Exercises.arguments!!) {
            // ...
        }

        composable(DDZRoutes.Exercise.route, arguments = DDZRoutes.Exercise.arguments!!) {
            // ...
        }
    }
}
