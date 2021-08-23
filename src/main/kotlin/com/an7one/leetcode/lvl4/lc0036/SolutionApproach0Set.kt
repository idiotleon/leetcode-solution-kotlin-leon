/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Time Complexity:     O(9 * 9) ~ O(1)
 * Space Complexity:    O(9 * 9) ~ O(1)
 */
package com.an7one.leetcode.lvl4.lc0036

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Set {
    private companion object {
        private const val SIZE = 9
        private const val EMPTY = '.'
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()
        for (row in 0 until SIZE) {
            for (col in 0 until SIZE) {
                if (board[row][col] == EMPTY)
                    continue

                val hash = "(${board[row][col]})"
                if (!seen.add("$hash$row")
                    || !seen.add("$col$hash")
                    || !seen.add("${row / 3}$hash${col / 3}")
                )
                    return false
            }
        }

        return true
    }
}