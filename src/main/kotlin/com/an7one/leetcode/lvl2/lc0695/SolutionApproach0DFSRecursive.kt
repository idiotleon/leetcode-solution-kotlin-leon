package com.an7one.leetcode.lvl2.lc0695

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/max-area-of-island/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)

        private const val WATER = 0
        private const val ISLAND = 1
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == WATER) continue
                val area = dfs(row, col, grid)
                maxArea = maxOf(maxArea, area)
            }
        }

        return maxArea
    }

    private fun dfs(row: Int, col: Int, grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        if (row < 0 || row >= nRows || col < 0 || col >= nCols || grid[row][col] != ISLAND) return 0

        grid[row][col] = WATER
        var area = 1

        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]

            area += dfs(nextRow, nextCol, grid)
        }

        return area
    }
}