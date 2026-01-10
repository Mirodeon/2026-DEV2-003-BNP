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

    @Test
    fun after_playing_a_move_current_player_switches() {
        val game = TicTacToeGame.newGame()

        val next = game.play(Position(1, 1))

        assertEquals(Player.O, next.currentPlayer)
    }

    @Test(expected = IllegalArgumentException::class)
    fun cannot_play_on_occupied_cell() {
        val game = TicTacToeGame.newGame()

        val afterFirstMove = game.play(Position(1, 1))

        afterFirstMove.play(Position(1, 1))
    }

    @Test(expected = IllegalArgumentException::class)
    fun cannot_play_outside_the_board() {
        val game = TicTacToeGame.newGame()
        val outOfBoundsRow = game.board.size

        game.play(Position(outOfBoundsRow, 0))
    }

    @Test
    fun player_wins_on_a_row() {
        val game = TicTacToeGame.newGame()
        val n = game.board.size

        var g = game
        for (col in 0 until n) {
            g = g.play(Position(0, col))
            if (col != n - 1) g = g.play(Position(1, col))
        }

        assertEquals(GameStatus.Won(Player.X), g.status)
    }
}