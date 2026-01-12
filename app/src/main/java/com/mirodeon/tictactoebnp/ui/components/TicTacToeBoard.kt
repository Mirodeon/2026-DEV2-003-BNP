package com.mirodeon.tictactoebnp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mirodeon.tictactoebnp.ui.theme.TicTacToeTheme

@Composable
fun TicTacToeBoard(
    boardSize: Int,
    cellLabel: (row: Int, col: Int) -> String,
    onCellClick: (row: Int, col: Int) -> Unit
) {
    val indices = (0 until boardSize * boardSize).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(boardSize),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .widthIn(max = 360.dp)
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .testTag("board"),
        horizontalArrangement = Arrangement.spacedBy(0.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp),
    ) {
        items(indices) { index ->
            val row = index / boardSize
            val col = index % boardSize

            TicTacToeCell(
                row = row,
                col = col,
                boardSize = boardSize,
                label = cellLabel(row, col),
                onClick = { onCellClick(row, col) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TicTacToeBoardPreview() {
    TicTacToeTheme {
        TicTacToeBoard(
            boardSize = 3,
            cellLabel = { _, _ ->
                "x"
            },
            onCellClick = { _, _ -> }
        )
    }
}