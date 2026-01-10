package com.mirodeon.tictactoebnp


class Board private constructor(
    val size: Int,
    private val cells: Array<Array<Player?>>
) {

    fun get(pos: Position): Player? {
        return cells[pos.row][pos.col]
    }

    fun place(pos: Position, player: Player): Board {
        if (cells[pos.row][pos.col] != null) {
            throw IllegalArgumentException("Cell already occupied")
        }

        val newCells = Array(size) { r -> cells[r].clone() }
        newCells[pos.row][pos.col] = player
        return Board(size, newCells)
    }

    companion object {
        fun empty(size: Int = 3): Board {
            val cells = Array(size) { arrayOfNulls<Player>(size) }
            return Board(size, cells)
        }
    }
}