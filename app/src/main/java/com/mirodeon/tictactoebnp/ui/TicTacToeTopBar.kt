package com.mirodeon.tictactoebnp.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicTacToeTopBar(
    onResetClick: () -> Unit
) {
    TopAppBar(
        title = { Text("Tic Tac Toe") },
        actions = {
            TextButton(
                onClick = onResetClick,
                modifier = Modifier.testTag("reset")
            ) {
                Text("Reset")
            }
        }
    )
}