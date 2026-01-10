package com.mirodeon.tictactoebnp

class TicTacToeGame private constructor(
    val currentPlayer: Player,
    val status: GameStatus,
    val board: Board
) {

    fun play(pos: Position): TicTacToeGame {
        val newBoard = board.place(pos, currentPlayer)
        return TicTacToeGame(
            currentPlayer = currentPlayer,
            status = status,
            board = newBoard
        )
    }

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