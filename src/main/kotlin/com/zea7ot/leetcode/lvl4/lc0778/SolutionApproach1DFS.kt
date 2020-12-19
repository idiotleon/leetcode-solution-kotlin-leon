/**
 * https://leetcode.com/problems/swim-in-rising-water/
 *
 * Time Complexity:     O(`time` * (`n` ^ 2 ))
 * Space Complexity:    O(`n` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/swim-in-rising-water/discuss/118204/Java-DFS-and-Union-Find
 */
package com.zea7ot.leetcode.lvl4.lc0778

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1DFS {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size

        var time = 0
        var visited = Array(n) { BooleanArray(n) { false } }

        while (!visited[n - 1][n - 1]) {
            visited = Array(n) { BooleanArray(n) { false } }
            dfs(0, 0, time, visited, grid)
            ++time
        }

        return time - 1
    }

    private fun dfs(row: Int, col: Int,
                    time: Int,
                    visited: Array<BooleanArray>,
                    grid: Array<IntArray>) {
        val n = grid.size

        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || grid[row][col] > time) return
        visited[row][col] = true

        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]
            dfs(nextRow, nextCol, time, visited, grid)
        }
    }

    private fun hash(row: Int, col: Int, n: Int) = row * n + col
}