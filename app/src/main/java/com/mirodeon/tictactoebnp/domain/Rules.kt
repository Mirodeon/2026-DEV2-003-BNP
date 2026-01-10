package com.mirodeon.tictactoebnp.domain

object Rules {

    fun evaluate(board: Board): GameStatus {
        winnerOnRows(board)?.let { return GameStatus.Won(it) }
        winnerOnColumns(board)?.let { return GameStatus.Won(it) }
        winnerOnMainDiagonal(board)?.let { return GameStatus.Won(it) }
        winnerOnAntiDiagonal(board)?.let { return GameStatus.Won(it) }

        if (board.isFull()) {
            return GameStatus.Draw
        }

        return GameStatus.InProgress
    }

    private fun winnerOnRows(board: Board): Player? {
        for (row in 0 until board.size) {
            val positions = (0 until board.size).map { col -> Position(row, col) }
            winnerOnLine(board, positions)?.let { return it }
        }
        return null
    }

    private fun winnerOnColumns(board: Board): Player? {
        for (col in 0 until board.size) {
            val positions = (0 until board.size).map { row -> Position(row, col) }
            winnerOnLine(board, positions)?.let { return it }
        }
        return null
    }

    private fun winnerOnMainDiagonal(board: Board): Player? {
        val positions = (0 until board.size).map { i -> Position(i, i) }
        return winnerOnLine(board, positions)
    }

    private fun winnerOnAntiDiagonal(board: Board): Player? {
        val last = board.size - 1
        val positions = (0 until board.size).map { i -> Position(i, last - i) }
        return winnerOnLine(board, positions)
    }

    private fun winnerOnLine(board: Board, positions: List<Position>): Player? {
        val first = board.get(positions.first()) ?: return null
        for (i in 1 until positions.size) {
            if (board.get(positions[i]) != first) {
                return null
            }
        }
        return first
    }
}