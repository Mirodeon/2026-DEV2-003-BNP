package com.mirodeon.tictactoebnp

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import org.junit.Rule
import org.junit.Test

class TicTacToeScreenTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun board_displays_9_cells() {
        rule.onAllNodesWithTag("cell", useUnmergedTree = true)
            .assertCountEquals(9)
    }
}
