package com.an7one.leetcode.lvl2.lc0064

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minPathSum(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val dp = Array(nRows) { IntArray(nCols) { 0 } }.also {
            it[0][0] = grid[0][0]
            for (row in 1 until nRows) it[row][0] = it[row - 1][0] + grid[row][0]
            for (col in 1 until nCols) it[0][col] = it[0][col - 1] + grid[0][col]
        }

        for (row in 1 until nRows) {
            for (col in 1 until nCols) {
                dp[row][col] = grid[row][col] + minOf(dp[row - 1][col], dp[row][col - 1])
            }
        }

        return dp[nRows - 1][nCols - 1]
    }
}