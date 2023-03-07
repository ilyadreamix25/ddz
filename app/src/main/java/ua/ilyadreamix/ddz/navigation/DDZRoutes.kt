package ua.ilyadreamix.ddz.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class DDZRoutes(val route: String, val arguments: List<NamedNavArgument>? = null) {
    object Grades : DDZRoutes("/")
    object Subjects : DDZRoutes("{grade}", listOf(gradeNavArg))
    object Lessons : DDZRoutes("{grade}/{subject}", listOf(gradeNavArg, subjectNavArg))
    object Exercises : DDZRoutes(
        "{grade}/{subject}/{lesson}",
        listOf(gradeNavArg, subjectNavArg, lessonNavArg)
    )
    object Exercise : DDZRoutes(
        "{grade}/{subject}/{lesson}/{exercise}",
        listOf(gradeNavArg, subjectNavArg, lessonNavArg, exerciseNavArg)
    )

    companion object {
        protected val gradeNavArg = navArgument("grade") {
            type = NavType.IntType
        }
        protected val subjectNavArg = navArgument("subject") {
            type = NavType.StringType
        }
        protected val lessonNavArg = navArgument("lesson") {
            type = NavType.StringType
        }
        protected val exerciseNavArg = navArgument("exercise") {
            type = NavType.StringType
        }
    }
}
