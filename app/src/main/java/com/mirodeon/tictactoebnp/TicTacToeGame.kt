package com.mirodeon.tictactoebnp

class TicTacToeGame private constructor(
    val currentPlayer: Player
) {

    companion object {
        fun newGame(): TicTacToeGame {
            return TicTacToeGame(Player.X)
        }
    }
}