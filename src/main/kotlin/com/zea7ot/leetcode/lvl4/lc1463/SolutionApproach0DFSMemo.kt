/**
 * https://leetcode.com/problems/cherry-pickup-ii/
 *
 * Time Complexity:     O(9 * `nRows` * (`nCols` ^ 2))
 * Space Complexity:    O(`nRows` * (`nCols` ^ 2))
 *
 * References:
 *  https://leetcode.com/problems/cherry-pickup-ii/discuss/660562/JavaC%2B%2BPython-Top-Down-DP-Clean-code
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1463-cherry-pickup-ii/
 */
package com.zea7ot.leetcode.lvl4.lc1463

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val memo = Array(nRows) { Array(nCols) { Array<Int?>(nCols) { null } } }
        return dfs(0, 0, nCols - 1, grid, memo)
    }

    private fun dfs(row: Int, col1: Int, col2: Int,
                    grid: Array<IntArray>,
                    memo: Array<Array<Array<Int?>>>): Int {

        val nRows = grid.size
        val nCols = grid[0].size

        if (row == nRows) return 0
        memo[row][col1][col2]?.let { return it }

        var ans = 0
        for (delta1 in -1..1) {
            for (delta2 in -1..1) {
                val nextCol1 = col1 + delta1
                val nextCol2 = col2 + delta2

                if (nextCol1 < 0 || nextCol1 >= nCols || nextCol2 < 0 || nextCol2 >= nCols) continue
                ans = maxOf(ans, dfs(row + 1, nextCol1, nextCol2, grid, memo))
            }
        }

        val cherries = if (col1 == col2) grid[row][col1] else grid[row][col1] + grid[row][col2]
        memo[row][col1][col2] = ans + cherries
        return memo[row][col1][col2]!!
    }
}