package com.mirodeon.tictactoebnp.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {
    private val _state = mutableStateOf(TicTacToeUiState())
    val state: State<TicTacToeUiState> = _state
}