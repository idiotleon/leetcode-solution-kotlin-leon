package com.idiotleon.leetcode.lvl3.lc2658

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0DfsRecursive {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)

        private const val LAND = 0
    }

    fun findMaxFish(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val visited = Array(nRows) { BooleanArray(nCols) { false } }
        var max = 0

        for (r in 0 until nRows) {
            for (c in 0 until nCols) {
                if (grid[r][c] > 0) {
                    val sum = dfs(r, c, grid, visited)
                    max = maxOf(max, sum)
                }
            }
        }

        return max
    }

    private fun dfs(r: Int, c: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size
        if (r !in 0 until nRows || c !in 0 until nCols || grid[r][c] == LAND || visited[r][c]) {
            return 0
        }

        var sum = grid[r][c]
        visited[r][c] = true
        for (d in 0 until 4) {
            val nextR = r + DIRS[d]
            val nextC = c + DIRS[d + 1]
            sum += dfs(nextR, nextC, grid, visited)
        }

        return sum
    }
}