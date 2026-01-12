package com.mirodeon.tictactoebnp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mirodeon.tictactoebnp.ui.components.TicTacToeTopBar
import com.mirodeon.tictactoebnp.ui.TicTacToeViewModel
import com.mirodeon.tictactoebnp.ui.components.TicTacToeBoard
import com.mirodeon.tictactoebnp.ui.theme.TicTacToeTheme

@Composable
fun TicTacToeScreen(
    vm: TicTacToeViewModel = viewModel()
) {
    val uiState = vm.state.value

    ScaffoldWithErrorSnackbar(
        errorMessage = uiState.errorMessage,
        onErrorConsumed = { vm.onErrorShown() },
        topBar = {
            TicTacToeTopBar(
                statusText = uiState.statusText,
                onResetClick = { vm.onNewGame() }
            )
        }
    ) {
        TicTacToeBoard(
            boardSize = uiState.boardSize,
            cellLabel = uiState::labelAt,
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