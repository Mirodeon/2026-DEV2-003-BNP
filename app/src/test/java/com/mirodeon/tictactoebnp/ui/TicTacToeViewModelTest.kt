package com.mirodeon.tictactoebnp.ui

import com.mirodeon.tictactoebnp.domain.GameStatus
import com.mirodeon.tictactoebnp.domain.Player
import com.mirodeon.tictactoebnp.domain.Position
import org.junit.Assert
import org.junit.Test

class TicTacToeViewModelTest {

    @Test
    fun starts_with_a_new_game() {
        val vm = TicTacToeViewModel()

        Assert.assertEquals(Player.X, vm.state.value.game.currentPlayer)
        Assert.assertEquals(GameStatus.InProgress, vm.state.value.game.status)
        Assert.assertEquals(3, vm.state.value.game.board.size)
        Assert.assertNull(vm.state.value.errorMessage)
    }

    @Test
    fun clicking_empty_cell_plays_a_move() {
        val vm = TicTacToeViewModel()

        vm.onCellClicked(1, 1)

        Assert.assertEquals(Player.X, vm.state.value.game.board.get(Position(1, 1)))
        Assert.assertEquals(Player.O, vm.state.value.game.currentPlayer)
        Assert.assertNull(vm.state.value.errorMessage)
    }
}