package com.mirodeon.tictactoebnp.ui

import com.mirodeon.tictactoebnp.domain.TicTacToeGame

data class TicTacToeUiState(
    val game: TicTacToeGame = TicTacToeGame.newGame(),
    val errorMessage: String? = null
)