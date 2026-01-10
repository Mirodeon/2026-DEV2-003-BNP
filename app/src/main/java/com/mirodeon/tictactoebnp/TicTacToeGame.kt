package com.mirodeon.tictactoebnp

class TicTacToeGame private constructor(
    val currentPlayer: Player,
    val status: GameStatus,
    val board: Board
) {

    fun play(pos: Position): TicTacToeGame {
        val newBoard = board.place(pos, currentPlayer)
        val newStatus = Rules.evaluate(newBoard)

        val nextPlayer = if (newStatus is GameStatus.InProgress) {
            when (currentPlayer) {
                Player.X -> Player.O
                Player.O -> Player.X
            }
        } else {
            currentPlayer
        }

        return TicTacToeGame(
            currentPlayer = nextPlayer,
            status = newStatus,
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