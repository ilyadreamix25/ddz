package ua.ilyadreamix.idxcomponents

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.pointerInteropFilter

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.changeAlphaOnPress(alpha: Float = 0.7f, onClick: () -> Unit) =
    composed {
        val pressed = remember { mutableStateOf(false) }
        val alphaState = animateFloatAsState(if (pressed.value) alpha else 1f, label = "Alpha")

        this.alpha(alphaState.value)
            .pointerInteropFilter { event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_CANCEL -> pressed.value = true
                    MotionEvent.ACTION_UP -> {
                        pressed.value = false
                        onClick()
                    }
                }
                true
            }
    }
