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

    @Test
    fun clicking_occupied_cell_sets_error_message() {
        val vm = TicTacToeViewModel()

        vm.onCellClicked(1, 1) // X
        vm.onCellClicked(1, 1) // invalid

        Assert.assertNotNull(vm.state.value.errorMessage)
    }

    @Test
    fun valid_move_clears_previous_error_message() {
        val vm = TicTacToeViewModel()

        vm.onCellClicked(1, 1) // X
        vm.onCellClicked(1, 1) // invalid → error
        Assert.assertNotNull(vm.state.value.errorMessage)

        vm.onCellClicked(0, 0) // valid move

        Assert.assertNull(vm.state.value.errorMessage)
    }

    @Test
    fun clicking_after_game_is_finished_sets_error_message() {
        val vm = TicTacToeViewModel()

        // X wins on row 0
        vm.onCellClicked(0, 0) // X
        vm.onCellClicked(1, 0) // O
        vm.onCellClicked(0, 1) // X
        vm.onCellClicked(1, 1) // O
        vm.onCellClicked(0, 2) // X -> win

        // invalid click after finished game -> error
        vm.onCellClicked(2, 2)

        Assert.assertNotNull(vm.state.value.errorMessage)
    }

    @Test
    fun new_game_resets_finished_game_and_clears_error_message() {
        val vm = TicTacToeViewModel()

        // X wins on row 0
        vm.onCellClicked(0, 0) // X
        vm.onCellClicked(1, 0) // O
        vm.onCellClicked(0, 1) // X
        vm.onCellClicked(1, 1) // O
        vm.onCellClicked(0, 2) // X -> win

        // invalid click after finished game -> error
        vm.onCellClicked(2, 2)

        vm.onNewGame()

        Assert.assertEquals(Player.X, vm.state.value.game.currentPlayer)
        Assert.assertEquals(GameStatus.InProgress, vm.state.value.game.status)
        Assert.assertEquals(3, vm.state.value.game.board.size)
        Assert.assertNull(vm.state.value.errorMessage)
    }
}