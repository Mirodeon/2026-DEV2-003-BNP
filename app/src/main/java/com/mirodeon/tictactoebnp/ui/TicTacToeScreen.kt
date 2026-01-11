package com.mirodeon.tictactoebnp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mirodeon.tictactoebnp.ui.theme.TicTacToeTheme

@Composable
fun TicTacToeScreen(boardSize: Int = 3) {
    val indices = (0 until boardSize * boardSize).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(boardSize),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .testTag("board"),
        horizontalArrangement = Arrangement.spacedBy(0.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp),
    ) {
        items(indices) { index ->
            val row = index / boardSize
            val col = index % boardSize

            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .testTag("cell")
                    .testTag("cell-$row-$col")
                    .ticTacToeInternalGridLines(
                        row = row,
                        col = col,
                        boardSize = boardSize
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TicTacToeScreenPreview() {
    TicTacToeTheme {
        TicTacToeScreen()
    }
}