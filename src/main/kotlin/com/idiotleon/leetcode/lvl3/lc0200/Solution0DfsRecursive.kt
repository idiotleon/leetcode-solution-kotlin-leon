package com.idiotleon.leetcode.lvl3.lc0200

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-islands/
 *
 * Time ComplexityP:        O(`nRows` * `nCols`)
 * Space Complexity:        O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0DfsRecursive {
    private companion object {
        private const val WATER = '0'
        private const val LAND = '1'

        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun numIslands(grid: Array<CharArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        var count = 0
        for (r in 0 until nRows) {
            for (c in 0 until nCols) {
                if (grid[r][c] == LAND) {
                    ++count
                    dfs(r, c, grid)
                }
            }
        }

        return count
    }

    private fun dfs(r: Int, c: Int, grid: Array<CharArray>) {
        val nRows = grid.size
        val nCols = grid[0].size

        if (r !in 0 until nRows || c !in 0 until nCols || grid[r][c] == WATER) {
            return
        }

        grid[r][c] = WATER

        for (d in 0 until 4) {
            val nextR = r + DIRS[d]
            val nextC = c + DIRS[d + 1]
            dfs(nextR, nextC, grid)
        }
    }
}