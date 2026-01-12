package com.mirodeon.tictactoebnp.ui.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.ticTacToeInternalGridLines(
    row: Int,
    col: Int,
    boardSize: Int,
    strokeWidth: Dp = 4.dp,
    color: Color = Color.Black
): Modifier = this.drawBehind {
    val strokePx = strokeWidth.toPx()
    val half = strokePx / 2f

    if (col < boardSize - 1) {
        drawLine(
            color = color,
            start = Offset(size.width - half, 0f),
            end = Offset(size.width - half, size.height),
            strokeWidth = strokePx
        )
    }

    if (row < boardSize - 1) {
        drawLine(
            color = color,
            start = Offset(0f, size.height - half),
            end = Offset(size.width, size.height - half),
            strokeWidth = strokePx
        )
    }
}