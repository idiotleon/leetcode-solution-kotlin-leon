/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-path-sum/discuss/185358/Easy-Recursive-Solution-with-memo-(Java)
 */
package com.an7one.leetcode.lvl2.lc0064

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun minPathSum(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val memo = Array(nRows) { Array<Int?>(nCols) { null } }

        return dfs(0, 0, grid, memo)
    }

    private fun dfs(row: Int, col: Int, grid: Array<IntArray>, memo: Array<Array<Int?>>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        if (row < 0 || row >= nRows || col < 0 || col >= nCols) return Int.MAX_VALUE
        memo[row][col]?.let { return it }

        if (row == nRows - 1 && col == nCols - 1) return grid[row][col]

        val minPathSum = grid[row][col] + minOf(dfs(row + 1, col, grid, memo), dfs(row, col + 1, grid, memo))
        memo[row][col] = minPathSum
        return minPathSum
    }
}