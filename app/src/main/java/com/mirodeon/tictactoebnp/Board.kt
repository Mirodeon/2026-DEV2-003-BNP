package com.mirodeon.tictactoebnp


class Board private constructor(
    val size: Int,
    private val cells: Array<Array<Player?>>
) {

    fun get(pos: Position): Player? {
        return cells[pos.row][pos.col]
    }

    companion object {
        fun empty(size: Int = 3): Board {
            val cells = Array(size) { arrayOfNulls<Player>(size) }
            return Board(size, cells)
        }
    }
}