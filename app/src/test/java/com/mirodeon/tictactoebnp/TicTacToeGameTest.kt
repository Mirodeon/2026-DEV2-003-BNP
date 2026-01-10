package com.mirodeon.tictactoebnp

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class TicTacToeGameTest {

    @Test
    fun x_starts_the_game() {
        val game = TicTacToeGame.newGame()

        assertEquals(Player.X, game.currentPlayer)
    }

    @Test
    fun game_starts_in_progress() {
        val game = TicTacToeGame.newGame()

        assertEquals(GameStatus.InProgress, game.status)
    }

    @Test
    fun board_is_3_by_3() {
        val game = TicTacToeGame.newGame()

        assertEquals(3, game.board.size)
    }

    @Test
    fun board_is_empty_at_start() {
        val game = TicTacToeGame.newGame()

        for (row in 0 until game.board.size) {
            for (col in 0 until game.board.size) {
                assertNull(game.board.get(Position(row, col)))
            }
        }
    }

    @Test
    fun playing_on_empty_cell_places_current_player_mark() {
        val game = TicTacToeGame.newGame()

        val next = game.play(Position(1, 1))

        assertEquals(Player.X, next.board.get(Position(1, 1)))
    }
}