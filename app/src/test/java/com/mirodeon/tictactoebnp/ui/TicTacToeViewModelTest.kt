package com.mirodeon.tictactoebnp.ui

import com.mirodeon.tictactoebnp.domain.GameStatus
import com.mirodeon.tictactoebnp.domain.Player
import org.junit.Assert
import org.junit.Test

class TicTacToeViewModelTest {

    @Test
    fun starts_with_a_new_game() {
        val vm = TicTacToeViewModel()

        Assert.assertEquals(Player.X, vm.state.game.currentPlayer)
        Assert.assertEquals(GameStatus.InProgress, vm.state.game.status)
        Assert.assertEquals(3, vm.state.game.board.size)
        Assert.assertNull(vm.state.errorMessage)
    }
}