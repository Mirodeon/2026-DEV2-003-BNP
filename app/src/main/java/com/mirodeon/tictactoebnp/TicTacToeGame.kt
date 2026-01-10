package com.mirodeon.tictactoebnp

class TicTacToeGame private constructor(
    val currentPlayer: Player,
    val status: GameStatus,
    val board: Board
) {

    fun play(pos: Position): TicTacToeGame {
        if (!isInProgress()) {
            throw IllegalStateException("Game is finished")
        }

        val newBoard = board.place(pos, currentPlayer)
        val newStatus = Rules.evaluate(newBoard)
        val nextPlayer = playerForNextState(newStatus)

        return TicTacToeGame(
            currentPlayer = nextPlayer,
            status = newStatus,
            board = newBoard
        )
    }

    private fun isInProgress(): Boolean {
        return status is GameStatus.InProgress
    }

    private fun playerForNextState(status: GameStatus): Player {
        return if (gameContinues(status)) {
            oppositePlayer()
        } else currentPlayer
    }

    private fun gameContinues(status: GameStatus): Boolean {
        return status is GameStatus.InProgress
    }

    private fun oppositePlayer(): Player {
        return when (currentPlayer) {
            Player.X -> Player.O
            Player.O -> Player.X
        }
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