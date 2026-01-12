package com.mirodeon.tictactoebnp.ui

import com.mirodeon.tictactoebnp.domain.GameStatus
import com.mirodeon.tictactoebnp.domain.Player
import com.mirodeon.tictactoebnp.domain.Position
import com.mirodeon.tictactoebnp.domain.TicTacToeGame

data class TicTacToeUiState(
    val game: TicTacToeGame = TicTacToeGame.newGame(),
    val errorMessage: String? = null
) {
    val boardSize get() = game.board.size

    val statusText: String
        get() = when (val status = game.status) {
            GameStatus.InProgress -> "${game.currentPlayer} to play"
            is GameStatus.Won -> "${status.winner} wins"
            GameStatus.Draw -> "Draw"
        }

    fun labelAt(row: Int, col: Int): String {
        return when (game.board.get(Position(row, col))) {
            Player.X -> "X"
            Player.O -> "O"
            null -> ""
        }
    }
}