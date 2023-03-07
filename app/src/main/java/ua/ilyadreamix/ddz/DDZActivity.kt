package ua.ilyadreamix.ddz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ua.ilyadreamix.ddz.components.DDZDevWatermark
import ua.ilyadreamix.ddz.navigation.DDZNavGraph
import ua.ilyadreamix.ddz.theme.DDZTheme

class DDZActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DDZTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    DDZNavGraph(navController = rememberNavController())
                    DDZDevWatermark()
                }
            }
        }
    }
}
