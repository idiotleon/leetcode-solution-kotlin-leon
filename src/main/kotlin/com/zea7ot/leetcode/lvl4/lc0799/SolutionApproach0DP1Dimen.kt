/**
 * https://leetcode.com/problems/champagne-tower/
 *
 * Time Complexity:     O(`queryRow` ^ 2)
 * Space Complexity:    O(`queryRow`)
 *
 * References:
 *  https://leetcode.com/problems/champagne-tower/discuss/118660/20ms-C++-Easy-understand-solution/593912
 *  https://leetcode.com/problems/champagne-tower/discuss/118692/9ms-5-Lines-Code-C%2B%2BJava
 *  https://leetcode.com/problems/champagne-tower/discuss/118711/JavaC%2B%2BPython-1D-DP-O(R)-space
 */
package com.zea7ot.leetcode.lvl4.lc0799

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun champagneTower(poured: Int, queryRow: Int, queryGlass: Int): Double {
        val dp = DoubleArray(queryRow + 1) { 0.0 }
        dp[0] = poured.toDouble()

        for (row in 0 until queryRow) {
            for (col in row downTo 0) {
                val overflow = maxOf(0.0, dp[col] - 1)
                dp[col + 1] += overflow / 2.0
                dp[col] = overflow / 2.0
            }
        }

        return minOf(dp[queryGlass], 1.0)
    }
}