/**
 * https://leetcode.com/problems/shortest-bridge/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/shortest-bridge/discuss/189321/Java-DFS-find-the-island-greater-BFS-expand-the-island/258399
 *  https://leetcode.com/problems/shortest-bridge/discuss/189321/Java-DFS-find-the-island-greater-BFS-expand-the-island
 */
package com.zea7ot.leetcode.lvl3.lc0934

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun shortestBridge(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val queue = LinkedList<Point>()
        val visited = Array(nRows) { BooleanArray(nCols) { false } }

        // to find any of the two island
        var found = false
        outer@ for (row in grid.indices) {
            inner@ for (col in grid[0].indices) {
                if (grid[row][col] == 1) {
                    dfs(row, col, visited, grid, queue)
                    found = true
                }

                if (found) break@outer
            }
        }

        // to BFS/expand to reach the other island
        var steps = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val (curRow, curCol) = queue.poll()

                for (d in 0 until 4) {
                    val nextRow = curRow + DIRS[d]
                    val nextCol = curCol + DIRS[d + 1]

                    if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols || visited[nextRow][nextCol]) continue

                    if (grid[nextRow][nextCol] == 1) return steps

                    queue.offer(Point(nextRow, nextCol))
                    visited[nextRow][nextCol] = true
                }
            }

            ++steps
        }

        return -1
    }

    private fun dfs(row: Int, col: Int,
                    visited: Array<BooleanArray>,
                    grid: Array<IntArray>,
                    queue: LinkedList<Point>) {
        val nRows = grid.size
        val nCols = grid[0].size

        if (row < 0 || col < 0 || row >= nRows || col >= nCols || visited[row][col] || grid[row][col] == 0) return

        visited[row][col] = true
        queue.offer(Point(row, col))
        for (d in 0 until 4) {
            dfs(row + DIRS[d], col + DIRS[d + 1], visited, grid, queue)
        }
    }

    private data class Point(val row: Int, val col: Int)
}