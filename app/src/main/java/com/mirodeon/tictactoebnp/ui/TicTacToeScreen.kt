package com.mirodeon.tictactoebnp.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mirodeon.tictactoebnp.domain.Player
import com.mirodeon.tictactoebnp.domain.Position
import com.mirodeon.tictactoebnp.ui.theme.TicTacToeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicTacToeScreen(
    vm: TicTacToeViewModel = viewModel()
) {
    val uiState = vm.state.value
    val boardSize = uiState.game.board.size

    ScaffoldWithErrorSnackbar(
        errorMessage = uiState.errorMessage,
        onErrorConsumed = { vm.onErrorShown() },
        topBar = {
            TopAppBar(
                title = { Text("Tic Tac Toe") },
                actions = {
                    TextButton(
                        onClick = { vm.onNewGame() },
                        modifier = Modifier.testTag("reset")
                    ) {
                        Text("Reset")
                    }
                }
            )
        }
    ) {
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
            onCellClick = { row, col -> vm.onCellClicked(row, col) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TicTacToeScreenPreview() {
    TicTacToeTheme {
        TicTacToeScreen()
    }
}