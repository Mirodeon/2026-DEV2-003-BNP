package com.mirodeon.tictactoebnp

import org.junit.Assert.assertEquals
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
}