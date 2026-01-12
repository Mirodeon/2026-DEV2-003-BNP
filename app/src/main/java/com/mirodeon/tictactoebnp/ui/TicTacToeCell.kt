package com.mirodeon.tictactoebnp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mirodeon.tictactoebnp.ui.theme.TicTacToeTheme

@Composable
fun TicTacToeCell(
    row: Int,
    col: Int,
    boardSize: Int,
    label: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .testTag("cell-$row-$col")
            .ticTacToeInternalGridLines(
                row = row,
                col = col,
                boardSize = boardSize
            )
            .clickable(onClick = onClick)
    ) {
        Text(
            text = label,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
                .testTag("cell-$row-$col-text"),
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TicTacToeCellPreview() {
    TicTacToeTheme {
        TicTacToeCell(
            row = 0,
            col = 0,
            boardSize = 3,
            label = "x",
            onClick = {}
        )
    }
}