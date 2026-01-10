package com.mirodeon.tictactoebnp

class TicTacToeGame private constructor(
    val currentPlayer: Player,
    val status: GameStatus,
    val board: Board
) {

    fun play(pos: Position): TicTacToeGame {
        val newBoard = board.place(pos, currentPlayer)

        val nextPlayer = when (currentPlayer) {
            Player.X -> Player.O
            Player.O -> Player.X
        }

        return TicTacToeGame(
            currentPlayer = nextPlayer,
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