package com.an7one.leetcode.lvl3.lc0120.topDown

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/triangle/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * a top-down approach to dissemble the problem into subproblems
 *
 * References:
 *  https://leetcode.com/problems/triangle/discuss/38918/C%2B%2B-top-down-and-bottom-up-solutions.
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val nRows = triangle.size
        // to initialize with the 0-th row
        val dp = IntArray(nRows) { triangle[0][0] }

        for (row in 1 until nRows) {
            for (col in row downTo 0) {
                when (col) {
                    0 -> dp[col] += triangle[row][col]
                    row -> dp[col] = triangle[row][col] + dp[col - 1]
                    else -> dp[col] = triangle[row][col] + minOf(dp[col - 1], dp[col])
                }
            }
        }

        return dp.minOrNull()!!
    }
}