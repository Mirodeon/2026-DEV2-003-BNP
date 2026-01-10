package com.mirodeon.tictactoebnp.domain

import org.junit.Assert
import org.junit.Test

class TicTacToeGameTest {

    //region --- New game / initial state ---
    @Test
    fun x_starts_the_game() {
        val game = TicTacToeGame.newGame()

        Assert.assertEquals(Player.X, game.currentPlayer)
    }

    @Test
    fun game_starts_in_progress() {
        val game = TicTacToeGame.newGame()

        Assert.assertEquals(GameStatus.InProgress, game.status)
    }

    @Test
    fun board_is_3_by_3() {
        val game = TicTacToeGame.newGame()

        Assert.assertEquals(3, game.board.size)
    }

    @Test
    fun board_is_empty_at_start() {
        val game = TicTacToeGame.newGame()

        for (row in 0 until game.board.size) {
            for (col in 0 until game.board.size) {
                Assert.assertNull(game.board.get(Position(row, col)))
            }
        }
    }
    //endregion

    //region --- Basic play / turn switching ---
    @Test
    fun playing_on_empty_cell_places_current_player_mark() {
        val game = TicTacToeGame.newGame()

        val next = game.play(Position(1, 1))

        Assert.assertEquals(Player.X, next.board.get(Position(1, 1)))
    }

    @Test
    fun after_playing_a_move_current_player_switches() {
        val game = TicTacToeGame.newGame()

        val next = game.play(Position(1, 1))

        Assert.assertEquals(Player.O, next.currentPlayer)
    }
    //endregion

    //region --- Invalid moves ---
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
    //endregion

    //region --- Win conditions ---
    @Test
    fun player_wins_on_a_row() {
        val game = TicTacToeGame.newGame()
        val n = game.board.size

        var g = game
        for (col in 0 until n) {
            g = g.play(Position(0, col))
            if (col != n - 1) {
                g = g.play(Position(1, col))
            }
        }

        Assert.assertEquals(GameStatus.Won(Player.X), g.status)
    }

    @Test
    fun player_wins_on_a_column() {
        val game = TicTacToeGame.newGame()
        val n = game.board.size

        var g = game
        for (row in 0 until n) {
            g = g.play(Position(row, 0))
            if (row != n - 1) {
                g = g.play(Position(row, 1))
            }
        }

        Assert.assertEquals(GameStatus.Won(Player.X), g.status)
    }

    @Test
    fun player_wins_on_main_diagonal() {
        val game = TicTacToeGame.newGame()
        val n = game.board.size

        var g = game
        for (i in 0 until n) {
            g = g.play(Position(i, i))
            if (i != n - 1) {
                g = g.play(Position(i, (i + 1) % n))
            }
        }

        Assert.assertEquals(GameStatus.Won(Player.X), g.status)
    }

    @Test
    fun player_wins_on_anti_diagonal() {
        val game = TicTacToeGame.newGame()
        val n = game.board.size

        var g = game
        for (i in 0 until n) {
            g = g.play(Position(i, n - 1 - i))
            if (i != n - 1) {
                val safeCol = (n - 2 - i + n) % n
                if (safeCol == n - 1 - i) {
                    g = g.play(Position(i, (safeCol + 1) % n))
                } else {
                    g = g.play(Position(i, safeCol))
                }
            }
        }

        Assert.assertEquals(GameStatus.Won(Player.X), g.status)
    }
    //endregion

    //region --- Draw / finished game ---
    @Test
    fun game_is_draw_when_board_is_full_without_winner() {
        // This kata is scoped to a 3x3 board, so we use a known 3x3 draw sequence.
        val game = TicTacToeGame.newGame()

        val finished = game
            .play(Position(0, 0)) // X
            .play(Position(0, 1)) // O
            .play(Position(0, 2)) // X
            .play(Position(1, 1)) // O
            .play(Position(1, 0)) // X
            .play(Position(1, 2)) // O
            .play(Position(2, 1)) // X
            .play(Position(2, 0)) // O
            .play(Position(2, 2)) // X

        Assert.assertEquals(GameStatus.Draw, finished.status)
    }

    @Test(expected = IllegalStateException::class)
    fun cannot_play_when_game_is_finished() {
        val game = TicTacToeGame.newGame()
        val n = game.board.size

        var g = game
        for (col in 0 until n) {
            g = g.play(Position(0, col))
            if (col != n - 1) {
                g = g.play(Position(1, col))
            }
        }

        g.play(Position(n - 1, n - 1))
    }
    //endregion
}