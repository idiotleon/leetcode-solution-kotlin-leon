/**
 * https://leetcode.com/problems/champagne-tower/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/champagne-tower/discuss/118660/20ms-C++-Easy-understand-solution/118202
 */
package com.zea7ot.leetcode.lvl4.lc0799

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun champagneTower(poured: Int, queryRow: Int, queryGlass: Int): Double {
        val memo = Array(queryRow + 1) { DoubleArray(queryGlass + 2) { 0.0 } }
        memo[0][0] = poured.toDouble()

        dfs(queryRow - 1, maxOf(0, queryGlass - 1), minOf(queryGlass, queryRow - 1), memo)

        return minOf(1.0, memo[queryRow][queryGlass])
    }

    private fun dfs(row: Int, loCol: Int, hiCol: Int, memo: Array<DoubleArray>) {
        if (row > 0) {
            dfs(row - 1, maxOf(loCol - 1, 0), minOf(hiCol, row - 1), memo)
        }

        for (col in loCol..hiCol) {
            if (memo[row][col] <= 1.0) continue

            val overflow = maxOf(0.0, memo[row][col] - 1)
            memo[row + 1][col] += overflow / 2.0
            memo[row + 1][col + 1] += overflow / 2.0
        }
    }
}