package com.an7one.leetcode.lvl3.lc0119

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Time Complexity:     O(`rowIndex`)
 * Space Complexity:    O(`rowIndex`)
 *
 * Reference:
 * https://leetcode.com/problems/pascals-triangle-ii/discuss/38584/Another-accepted-Java-solution/653049
 * https://leetcode.com/problems/pascals-triangle-ii/discuss/38584/Another-accepted-Java-solution
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun getRow(rowIndex: Int): List<Int> {
        // sanity check
        if (rowIndex < 0) return mutableListOf()

        val dp = MutableList(rowIndex + 1) { 1 }

        for (row in 1..rowIndex) {
            for (col in row - 1 downTo 1) {
                dp[col] = dp[col] + dp[col - 1]
            }
        }

        return dp
    }
}