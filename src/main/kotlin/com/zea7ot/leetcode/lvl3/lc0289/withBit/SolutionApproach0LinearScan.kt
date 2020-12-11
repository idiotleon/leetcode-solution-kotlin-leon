/**
 * https://leetcode.com/problems/game-of-life/
 *
 * Time Complexity:     O(`totalRows` * `totalCols`)
 * Space Complexity:    O(1)
 *
 * to acquire the current state:    `board[row][col] & 1`
 * to acquire the next state:       `board[row][col] >> 1`
 *
 * References:
 *  https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
 */
package com.zea7ot.leetcode.lvl3.lc0289.withBit

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    private companion object {
        private const val INITIAL_DEAD = 0
        private const val INITIAL_LIVE = 1
        private const val GOING_TO_DIE = INITIAL_DEAD or (1 shl 1) // 01 -> 11
        private const val GOING_TO_LIVE = INITIAL_LIVE or (1 shl 1) // 00 -> 10
    }

    fun gameOfLife(board: Array<IntArray>) {
        // not used
        // val totalRows = board.size
        // val totalCols = board[0].size

        for (row in board.indices) {
            for (col in board[0].indices) {
                val lives = getLiveNeighbors(row, col, board)

                if (board[row][col] == INITIAL_LIVE && lives >= 2 && lives <= 3) {
                    board[row][col] = GOING_TO_LIVE
                }

                if (board[row][col] == INITIAL_DEAD && lives == 3) {
                    board[row][col] = GOING_TO_DIE
                }
            }
        }

        for (row in board.indices) {
            for (col in board[0].indices) {
                board[row][col] = board[row][col] shr 1
            }
        }
    }

    private fun getLiveNeighbors(row: Int, col: Int, board: Array<IntArray>): Int {
        val totalRows = board.size
        val totalCols = board[0].size

        var lives = 0
        for (nextRow in maxOf(row - 1, 0)..minOf(row + 1, totalRows - 1)) {
            for (nextCol in maxOf(col - 1, 0)..minOf(col + 1, totalCols - 1)) {
                lives += board[nextRow][nextCol] and 1
            }
        }
        lives -= board[row][col] and 1
        return lives
    }
}