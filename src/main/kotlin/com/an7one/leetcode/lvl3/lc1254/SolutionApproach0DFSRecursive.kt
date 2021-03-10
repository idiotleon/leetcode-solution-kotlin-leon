/**
 * https://leetcode.com/problems/number-of-closed-islands/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-closed-islands/discuss/425135/Java-Very-Simple-DFS-Solution
 *  https://leetcode.com/problems/number-of-closed-islands/discuss/425135/Java-Very-Simple-DFS-Solution/383149
 */
package com.an7one.leetcode.lvl3.lc1254

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun closedIsland(grid: Array<IntArray>): Int {
        var count = 0

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 0) {
                    if (dfs(row, col, grid)) {
                        ++count
                    }
                }
            }
        }

        return count
    }

    private fun dfs(curRow: Int, curCol: Int, grid: Array<IntArray>): Boolean {
        val nRows = grid.size
        val nCols = grid[0].size

        if (curRow < 0 || curRow >= nRows || curCol < 0 || curCol >= nCols) return false

        if (grid[curRow][curCol] == 1) return true
        grid[curRow][curCol] = 1

        var isClosed = true
        for (d in 0 until 4) {
            val nextRow = curRow + DIRS[d]
            val nextCol = curCol + DIRS[d + 1]

            if (!dfs(nextRow, nextCol, grid)) {
                isClosed = false
            }
        }

        return isClosed
    }
}