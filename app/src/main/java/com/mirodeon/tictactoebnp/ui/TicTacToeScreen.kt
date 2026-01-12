package com.mirodeon.tictactoebnp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mirodeon.tictactoebnp.domain.Player
import com.mirodeon.tictactoebnp.domain.Position
import com.mirodeon.tictactoebnp.ui.theme.TicTacToeTheme

@Composable
fun TicTacToeScreen(
    vm: TicTacToeViewModel = viewModel(),
    boardSize: Int = 3
) {
    val uiState = vm.state.value
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

            val mark = uiState.game.board.get(Position(row, col))
            val label = when (mark) {
                Player.X -> "X"
                Player.O -> "O"
                null -> ""
            }

            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .testTag("cell-$row-$col")
                    .ticTacToeInternalGridLines(
                        row = row,
                        col = col,
                        boardSize = boardSize
                    )
                    .clickable { vm.onCellClicked(row, col) }
            ) {
                Text(
                    text = label,
                    modifier = Modifier.testTag("cell-$row-$col-text")
                )
            }
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