package com.mirodeon.tictactoebnp.ui

import com.mirodeon.tictactoebnp.domain.TicTacToeGame
import org.junit.Assert
import org.junit.Test

class TicTacToeViewModelTest {

    @Test
    fun starts_with_a_new_game() {
        val vm = TicTacToeViewModel()

        Assert.assertEquals(TicTacToeGame.newGame(), vm.state.game)
        Assert.assertNull(vm.state.errorMessage)
    }
}