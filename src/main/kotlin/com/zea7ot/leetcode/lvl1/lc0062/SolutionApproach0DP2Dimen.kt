/**
 * https://leetcode.com/problems/unique-paths/
 *
 * Time Complexity:     O(`m` * `n`)
 * Space Complexity:    O(`m` * `n`)
 *
 * References:
 *  https://youtu.be/BxblkIz6TZc?t=518
 */
package com.zea7ot.leetcode.lvl1.lc0062

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { 0 } }
        for (row in 0 until m) dp[row][0] = 1
        for (col in 0 until n) dp[0][col] = 1

        for (row in 1 until m) {
            for (col in 1 until n) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1]
            }
        }

        return dp[m - 1][n - 1]
    }
}