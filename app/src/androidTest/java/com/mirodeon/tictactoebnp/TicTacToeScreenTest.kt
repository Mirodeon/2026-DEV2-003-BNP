package com.mirodeon.tictactoebnp

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TicTacToeScreenTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun board_displays_9_cells() {
        rule.onAllNodes(hasTestTagRegex(Regex("cell-\\d+-\\d+")), useUnmergedTree = true)
            .assertCountEquals(9)
    }

    private fun hasTestTagRegex(regex: Regex): SemanticsMatcher {
        return SemanticsMatcher("Has test tag matching $regex") { node ->
            val tag = node.config.getOrNull(SemanticsProperties.TestTag)
            tag != null && regex.matches(tag)
        }
    }

    @Test
    fun clicking_a_cell_displays_x() {
        rule.onNodeWithTag("cell-1-1", useUnmergedTree = true).performClick()
        rule.onNodeWithTag("cell-1-1-text", useUnmergedTree = true).assertTextEquals("X")
    }

    @Test
    fun invalid_move_shows_snackbar() {
        rule.onNodeWithTag("cell-1-1", useUnmergedTree = true).performClick()
        rule.onNodeWithTag("cell-1-1", useUnmergedTree = true).performClick()

        rule.onNodeWithTag("snackbar", useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun reset_clears_the_board() {
        rule.onNodeWithTag("cell-1-1", useUnmergedTree = true).performClick()
        rule.onNodeWithTag("cell-1-1-text", useUnmergedTree = true).assertTextEquals("X")

        rule.onNodeWithTag("reset", useUnmergedTree = true).performClick()

        rule.onNodeWithTag("cell-1-1-text", useUnmergedTree = true).assertTextEquals("")
    }

    @Test
    fun status_shows_current_player_at_start() {
        rule.onNodeWithTag("status", useUnmergedTree = true).assertTextContains("X")
    }
}
