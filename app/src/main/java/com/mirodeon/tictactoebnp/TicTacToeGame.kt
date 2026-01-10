package com.mirodeon.tictactoebnp

class TicTacToeGame private constructor(
    val currentPlayer: Player,
    val status: GameStatus,
    val board: Board
) {

    fun play(pos: Position): TicTacToeGame {
        val newBoard = board.place(pos, currentPlayer)

        val newStatus = evaluateStatus(newBoard)

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

    private fun evaluateStatus(board: Board): GameStatus {
        for (row in 0 until board.size) {
            val first = board.get(Position(row, 0))
            if (first != null) {
                var allSame = true
                for (col in 1 until board.size) {
                    if (board.get(Position(row, col)) != first) {
                        allSame = false
                        break
                    }
                }
                if (allSame) {
                    return GameStatus.Won(first)
                }
            }
        }
        return GameStatus.InProgress
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