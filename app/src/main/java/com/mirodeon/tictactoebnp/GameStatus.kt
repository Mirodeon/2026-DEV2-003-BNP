package com.mirodeon.tictactoebnp

sealed class GameStatus {
    data object InProgress : GameStatus()
    data object Draw : GameStatus()
    data class Won(val winner: Player) : GameStatus()
}