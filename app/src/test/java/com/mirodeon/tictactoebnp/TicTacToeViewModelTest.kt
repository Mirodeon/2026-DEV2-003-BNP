package com.mirodeon.tictactoebnp

import com.mirodeon.tictactoebnp.domain.TicTacToeGame
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class TicTacToeViewModelTest {

    @Test
    fun starts_with_a_new_game() {
        val vm = TicTacToeViewModel()

        assertEquals(TicTacToeGame.newGame(), vm.state.game)
        assertNull(vm.state.errorMessage)
    }
}