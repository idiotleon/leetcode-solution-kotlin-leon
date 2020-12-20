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

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val memo = Array(nRows) { Array(nCols) { Array<Int?>(nCols) { null } } }
        return dfs(0, 0, nCols - 1, grid, memo)
    }

    private fun dfs(
        curRow: Int,
        curCol1: Int,
        curCol2: Int,
        grid: Array<IntArray>,
        memo: Array<Array<Array<Int?>>>
    ): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        if (curRow == nRows) return 0
        memo[curRow][curCol1][curCol2]?.let { return it }

        var cherries = 0
        for (delta1 in -1..1) {
            for (delta2 in -1..1) {
                val nextCol1 = curCol1 + delta1
                val nextCol2 = curCol2 + delta2

                if (nextCol1 < 0 || nextCol1 >= nCols || nextCol2 < 0 || nextCol2 >= nCols) continue
                cherries = maxOf(cherries, dfs(curRow + 1, nextCol1, nextCol2, grid, memo))
            }
        }

        cherries += if (curCol1 == curCol2) grid[curRow][curCol1] else grid[curRow][curCol1] + grid[curRow][curCol2]
        memo[curRow][curCol1][curCol2] = cherries
        return cherries
    }
}