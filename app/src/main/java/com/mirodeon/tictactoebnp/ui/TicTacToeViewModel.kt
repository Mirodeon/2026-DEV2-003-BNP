package com.mirodeon.tictactoebnp.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mirodeon.tictactoebnp.domain.Position

class TicTacToeViewModel : ViewModel() {
    private val _state = mutableStateOf(TicTacToeUiState())
    val state: State<TicTacToeUiState> = _state

    fun onCellClicked(row: Int, col: Int) {
        val nextGame = _state.value.game.play(Position(row, col))
        _state.value = _state.value.copy(game = nextGame, errorMessage = null)
    }
}