/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Time Complexity:     O(`m` * `n`)
 * Space Complexity:    O(`m` * `n`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-path-sum/discuss/185358/Easy-Recursive-Solution-with-memo-(Java)
 */
package com.zea7ot.leetcode.lvl2.lc0064

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val memo = Array(m) { Array<Int?>(n) { null } }

        return dfs(0, 0, grid, memo)
    }

    private fun dfs(row: Int, col: Int, grid: Array<IntArray>, memo: Array<Array<Int?>>): Int {
        val m = grid.size
        val n = grid[0].size

        if (row < 0 || row >= m || col < 0 || col >= n) return Int.MAX_VALUE
        memo[row][col]?.let { return it }

        if (row == m - 1 && col == n - 1) return grid[row][col]

        val minPathSum = grid[row][col] + minOf(dfs(row + 1, col, grid, memo), dfs(row, col + 1, grid, memo))
        memo[row][col] = minPathSum
        return minPathSum
    }
}