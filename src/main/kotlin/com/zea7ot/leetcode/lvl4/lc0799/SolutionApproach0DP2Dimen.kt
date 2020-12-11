/**
 * https://leetcode.com/problems/champagne-tower/
 *
 * Time Complexity:     O(`RANGE` ^ 2)
 * Space Complexity:    O(`RANGE` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/champagne-tower/discuss/118660/20ms-C%2B%2B-Easy-understand-solution
 */
package com.zea7ot.leetcode.lvl4.lc0799

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val RANGE = 100 + 1
    }

    fun champagneTower(poured: Int, queryRow: Int, queryGlass: Int): Double {
        val dp = Array(RANGE) { DoubleArray(RANGE) { 0.0 } }
        dp[0][0] = poured.toDouble()

        for (row in 0 until RANGE - 1) {
            for (col in 0..row) {
                if (dp[row][col] >= 1) {
                    dp[row + 1][col] += (dp[row][col] - 1) / 2.0
                    dp[row + 1][col + 1] += (dp[row][col] - 1) / 2.0
                    dp[row][col] = 1.0
                }
            }
        }

        return dp[queryRow][queryGlass]
    }
}