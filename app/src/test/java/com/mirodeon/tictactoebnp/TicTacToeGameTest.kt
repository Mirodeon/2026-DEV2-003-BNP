package com.mirodeon.tictactoebnp

import org.junit.Assert.assertEquals
import org.junit.Test

class TicTacToeGameTest {

    @Test
    fun x_starts_the_game() {
        val game = TicTacToeGame.newGame()

        assertEquals(Player.X, game.currentPlayer)
    }
}