package com.an7one.leetcode.lvl1.lc0062

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/unique-paths/
 *
 * Time Complexity:     O(`m` * `n`)
 * Space Complexity:    O(`m` * `n`)
 *
 * Reference:
 * https://youtu.be/BxblkIz6TZc?t=512
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { 0 } }
        for (row in 0 until m) {
            dp[row][0] = 1
        }
        for (col in 0 until n) {
            dp[0][col] = 1
        }

        for (row in 0 until m - 1) {
            for (col in 0 until n - 1) {
                dp[row + 1][col + 1] = dp[row][col + 1] + dp[row + 1][col]
            }
        }

        return dp[m - 1][n - 1]
    }
}