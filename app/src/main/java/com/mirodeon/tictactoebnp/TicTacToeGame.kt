package com.mirodeon.tictactoebnp

class TicTacToeGame private constructor(
    val currentPlayer: Player,
    val status: GameStatus,
    val board: Board
) {

    companion object {
        fun newGame(): TicTacToeGame {
            return TicTacToeGame(
                currentPlayer = Player.X,
                status = GameStatus.InProgress,
                board = Board.empty()
            )
        }
    }
}