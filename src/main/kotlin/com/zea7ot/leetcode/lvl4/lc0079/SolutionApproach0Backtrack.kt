/**
 * https://leetcode.com/problems/word-search/
 *
 * Time Complexity:     O(`nRows` * `nCols` * (4 ^ `lenW`))
 *  `nRows`, `nCols`: sizes of the char[][] `board`
 *  `lenW`: length of the word
 *
 * Space Complexity:    O(`lenW`)
 *  `lenW`: length of the word
 *
 * References:
 *   https://www.bilibili.com/video/BV1M4411Q7td
 */
package com.zea7ot.leetcode.lvl4.lc0079

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
        private const val IMPOSSIBLE = '#'
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (backtrack(row, col, 0, board, word)) {
                    return true
                }
            }
        }

        return false
    }

    private fun backtrack(
        row: Int,
        col: Int,
        idxS: Int,
        board: Array<CharArray>,
        word: String
    ): Boolean {
        val lenW = word.length
        val nRows = board.size
        val nCols = board[0].size

        if (idxS == lenW) return true
        if (row < 0 || row >= nRows || col < 0 || col >= nCols || board[row][col] != word[idxS]) return false

        val hold = board[row][col]
        board[row][col] = IMPOSSIBLE

        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]

            if (backtrack(nextRow, nextCol, idxS + 1, board, word))
                return true
        }

        board[row][col] = hold
        return false
    }
}