/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Time Complexity:     O(`m` * `n`)
 * Space Complexity:    O(`m` * `n`)
 */
package com.zea7ot.leetcode.lvl2.lc0064

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(m) { IntArray(n) { 0 } }.also {
            it[0][0] = grid[0][0]
            for (row in 1 until m) it[row][0] = it[row - 1][0] + grid[row][0]
            for (col in 1 until n) it[0][col] = it[0][col - 1] + grid[0][col]
        }

        for (row in 1 until m) {
            for (col in 1 until n) {
                dp[row][col] = grid[row][col] + minOf(dp[row - 1][col], dp[row][col - 1])
            }
        }

        return dp[m - 1][n - 1]
    }
}