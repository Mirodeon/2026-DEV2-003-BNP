package com.mirodeon.tictactoebnp.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mirodeon.tictactoebnp.ui.theme.TicTacToeTheme

@Composable
fun TicTacToeScreen() {
    val indices = (0 until 9).toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .testTag("board"),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp),
    ) {
        items(indices) {
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(2.dp, Color.Black, RectangleShape)
                    .testTag("cell")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TicTacToeScreenPreview() {
    TicTacToeTheme {
        TicTacToeScreen()
    }
}