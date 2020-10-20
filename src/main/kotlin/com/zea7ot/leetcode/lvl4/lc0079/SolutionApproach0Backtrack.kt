/**
 * https://leetcode.com/problems/word-search/
 *
 * Time Complexity:     O(`totalRows` * `totalCols` * (4 ^ `lenW`))
 *  `totalRows`, `totalCols`: sizes of the char[][] `board`
 *  `lenW`: length of the word
 *
 * Space Complexity:    O(`lenW`)
 *  `lenW`: length of the word
 */
package com.zea7ot.leetcode.lvl4.lc0079

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private const val IMPOSSIBLE = '#'
        private val DIRS = arrayOf(0, -1, 0, 1, 0)
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val totalRows = board.size
        val totalCols = board[0].size

        for (row in 0 until totalRows) {
            for (col in 0 until totalCols) {
                if (backtrack(row, col, 0, word, board)) {
                    return true
                }
            }
        }

        return false
    }

    private fun backtrack(row: Int, col: Int,
                          idx: Int,
                          word: String,
                          board: Array<CharArray>): Boolean {
        val lenW = word.length
        if (idx == lenW) return true

        val totalRows = board.size
        val totalCols = board[0].size

        if (row < 0 || col < 0 || row >= totalRows || col >= totalCols || board[row][col] != word[idx]) return false

        val hold = board[row][col]
        board[row][col] = IMPOSSIBLE

        var exists = false

        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]

            exists = exists || backtrack(nextRow, nextCol, idx + 1, word, board)

        }

        board[row][col] = hold

        return exists
    }
}