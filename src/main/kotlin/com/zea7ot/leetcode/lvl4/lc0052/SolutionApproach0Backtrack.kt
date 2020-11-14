/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/n-queens-ii/discuss/20048/Easiest-Java-Solution-(1ms-98.22)
 *  https://leetcode.wang/leetCode-52-N-QueensII.html
 */
package com.zea7ot.leetcode.lvl4.lc0052

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun totalNQueens(n: Int): Int {

        val cols = BooleanArray(n) { false }
        val diag = BooleanArray(2 * n) { false }
        val antiDiag = BooleanArray(2 * n) { false }

        val count = intArrayOf(0)
        backtrack(0, cols, diag, antiDiag, n, count)

        return count[0]
    }

    private fun backtrack(row: Int,
                          cols: BooleanArray,
                          diag: BooleanArray,
                          antiDiag: BooleanArray,
                          n: Int,
                          count: IntArray) {

        if (row == n) ++count[0]

        for (col in 0 until n) {
            val dia = row + col
            val anti = col - row + n

            if (cols[col] || diag[dia] || antiDiag[anti]) continue

            cols[col] = true
            diag[dia] = true
            antiDiag[anti] = true

            backtrack(row + 1, cols, diag, antiDiag, n, count)

            cols[col] = false
            diag[dia] = false
            antiDiag[anti] = false
        }
    }
}