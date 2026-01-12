package com.mirodeon.tictactoebnp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mirodeon.tictactoebnp.domain.Player
import com.mirodeon.tictactoebnp.domain.Position
import com.mirodeon.tictactoebnp.ui.theme.TicTacToeTheme

@Composable
fun TicTacToeScreen(
    vm: TicTacToeViewModel = viewModel()
) {
    val uiState = vm.state.value
    val boardSize = uiState.game.board.size

    TicTacToeBoard(
        boardSize = boardSize,
        cellLabel = { row, col ->
            val mark = uiState.game.board.get(Position(row, col))
            when (mark) {
                Player.X -> "X"
                Player.O -> "O"
                null -> ""
            }
        },
        onCellClick = { row, col ->
            vm.onCellClicked(row, col)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TicTacToeScreenPreview() {
    TicTacToeTheme {
        TicTacToeScreen()
    }
}