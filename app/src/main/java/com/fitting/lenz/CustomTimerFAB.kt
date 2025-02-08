package com.fitting.lenz

import android.graphics.Color.parseColor
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun CustomTimerFAB(
    modifier: Modifier,
    countdownSeconds: Int,
    onCountdownEnd: () -> Unit
) {
    val context = LocalContext.current
    var currentSeconds by remember { mutableIntStateOf(countdownSeconds) }
    var isTimerRunning by remember { mutableStateOf(false) }

    LaunchedEffect(currentSeconds) {
        if (currentSeconds == 0) {
            onCountdownEnd()
            isTimerRunning = false
        }
    }

    LaunchedEffect(isTimerRunning) {
        while (isTimerRunning && currentSeconds > 0) {
            delay(1000L)
            if (isTimerRunning) {
                currentSeconds -= 1
            }
        }
    }

    Box(
        modifier = modifier.size(100.dp).padding(16.dp)
    ) {
        Canvas(
            modifier = Modifier
                .align(Alignment.Center)
                .size(80.dp)
        ) {
            drawArc(
                color = Color.DarkGray,
                startAngle = -90f,
                sweepAngle = (currentSeconds.toFloat() / countdownSeconds.toFloat()) * 360f,
                useCenter = false,
                style = Stroke(width = 4.dp.toPx())
            )
        }

        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Press and Hold for 5 Seconds to Confirm", Toast.LENGTH_SHORT).show()
            },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.Center)
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent(PointerEventPass.Initial)
                            val pressed = event.changes.any { it.pressed }

                            if (pressed && !isTimerRunning) {
                                isTimerRunning = true
                            } else if (!pressed && isTimerRunning) {
                                isTimerRunning = false
                            }

                            if (!pressed && currentSeconds != countdownSeconds) {
                                currentSeconds = countdownSeconds
                            }
                        }
                    }
                }
        ) {
            Icon(
                painter = painterResource(R.drawable.complete),
                contentDescription = "Schedule",
                tint = Color(parseColor("#38b000"))
            )
        }
    }
}