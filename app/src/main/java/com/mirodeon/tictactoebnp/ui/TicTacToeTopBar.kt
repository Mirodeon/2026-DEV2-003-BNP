package com.mirodeon.tictactoebnp.ui

import androidx.compose.foundation.layout.Column
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
    statusText: String,
    onResetClick: () -> Unit
) {
    TopAppBar(
        title = {
            Column {
                Text("Tic Tac Toe")
                Text(
                    text = statusText,
                    modifier = Modifier.testTag("status")
                )
            }
        },
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