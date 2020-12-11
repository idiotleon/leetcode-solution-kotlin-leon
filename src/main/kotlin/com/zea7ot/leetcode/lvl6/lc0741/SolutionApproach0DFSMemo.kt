/**
 * https://leetcode.com/problems/cherry-pickup/
 *
 * Time Complexity:         O(N ^ 3)
 * Space Complexity:        O(N ^ 3)
 *
 * References:
 *  https://youtu.be/vvPSWORCKow
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-741-cherry-pickup/
 */
package com.zea7ot.leetcode.lvl6.lc0741

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val memo = Array(nRows) { Array(nCols) { IntArray(nCols) { Int.MIN_VALUE } } }
        return maxOf(0, dfs(nRows - 1, nCols - 1, nCols - 1, grid, memo))
    }

    private fun dfs(row1: Int, col1: Int, col2: Int,
                    grid: Array<IntArray>,
                    memo: Array<Array<IntArray>>): Int {
        val row2 = row1 + col1 - col2
        if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0) return -1
        if (grid[row1][col1] < 0 || grid[row2][col2] < 0) return -1
        if (row1 == 0 && col1 == 0) return grid[row1][col1]
        if (memo[row1][col1][col2] != Int.MIN_VALUE) return memo[row1][col1][col2]

        var max = maxOf(maxOf(dfs(row1, col1 - 1, col2 - 1, grid, memo),
                dfs(row1 - 1, col1, col2, grid, memo)),
                maxOf(dfs(row1 - 1, col1, col2 - 1, grid, memo),
                        dfs(row1, col1 - 1, col2, grid, memo)))

        if (max >= 0) {
            max += grid[row1][col1]
            if (col1 != col2) max += grid[row2][col2]
        }

        memo[row1][col1][col2] = max
        return max
    }
}