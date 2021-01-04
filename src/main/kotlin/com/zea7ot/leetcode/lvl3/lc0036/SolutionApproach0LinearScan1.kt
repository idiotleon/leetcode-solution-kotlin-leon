/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Time Complexity:     O(9 * 9)
 * Space Complexity:    O(9 * 9)
 *
 * References:
 *  https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code/146624
 *  https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code
 */
package com.zea7ot.leetcode.lvl3.lc0036

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    private companion object {
        private const val EMPTY = '.'
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()

        for (row in board.indices) {
            for (col in board[row].indices) {
                val value = board[row][col]
                if (value == EMPTY) continue

                val block = (row / 3 * 3) + (col / 3)
                if (!seen.add("row#$row#$value")
                    || !seen.add("col#$col$value")
                    || !seen.add("block#$block$value")
                )
                    return false
            }
        }

        return true
    }
}