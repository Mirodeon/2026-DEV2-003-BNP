package com.mirodeon.tictactoebnp.domain

class Board private constructor(
    val size: Int,
    private val cells: Array<Array<Player?>>
) {

    fun get(pos: Position): Player? {
        return cells[pos.row][pos.col]
    }

    fun place(pos: Position, player: Player): Board {
        require(pos.row in 0 until size && pos.col in 0 until size) {
            "Position out of bounds"
        }
        if (cells[pos.row][pos.col] != null) {
            throw IllegalArgumentException("Cell already occupied")
        }

        val newCells = Array(size) { r -> cells[r].clone() }
        newCells[pos.row][pos.col] = player
        return Board(size, newCells)
    }

    fun isFull(): Boolean {
        for (row in 0 until size) {
            for (col in 0 until size) {
                if (get(Position(row, col)) == null) {
                    return false
                }
            }
        }
        return true
    }

    companion object {
        fun empty(size: Int = 3): Board {
            val cells = Array(size) { arrayOfNulls<Player>(size) }
            return Board(size, cells)
        }
    }
}