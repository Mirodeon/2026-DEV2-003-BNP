package com.mirodeon.tictactoebnp

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
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

    @Test
    fun clicking_a_cell_displays_x() {
        rule.onNodeWithTag("cell-1-1", useUnmergedTree = true).performClick()
        rule.onNodeWithTag("cell-1-1-text", useUnmergedTree = true).assertTextEquals("X")
    }
}
