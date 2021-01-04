/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Time Complexity:     O(9 * 9)
 * Space Complexity:    O(9 * 9)
 *
 * References:
 *  https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
 */
package com.zea7ot.leetcode.lvl3.lc0036

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan2 {
    private companion object {
        private const val EMPTY = '.'
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()

        for (row in board.indices) {
            for (col in board[row].indices) {
                val value = board[row][col]
                if (value == EMPTY) continue

                val hash = "($value)"
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