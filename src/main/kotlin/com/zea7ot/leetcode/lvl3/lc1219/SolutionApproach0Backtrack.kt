/**
 * https://leetcode.com/problems/path-with-maximum-gold/
 *
 * Time Complexity:     O(4 * (3 ^ k))
 *  k, number of cells with gold
 *
 * Space Complexity:    O(k)
 *  k, consumed by the call stacks
 *
 * References:
 *  https://leetcode.com/problems/path-with-maximum-gold/discuss/398388/JavaC%2B%2BPython-DFS-Backtracking-Clean-code-O(4*3k)
 */
package com.zea7ot.leetcode.lvl3.lc1219

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun getMaximumGold(grid: Array<IntArray>): Int {

        var maxGold = 0
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                maxGold = maxOf(maxGold, dfs(row, col, grid))
            }
        }

        return maxGold
    }

    private fun dfs(row: Int, col: Int, grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        if (row < 0 || row >= nRows || col < 0 || col >= nCols || grid[row][col] == 0) return 0

        val origin = grid[row][col]

        grid[row][col] = 0

        var maxGold = 0

        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]

            maxGold = maxOf(maxGold, dfs(nextRow, nextCol, grid))
        }

        grid[row][col] = origin
        return maxGold + origin
    }
}