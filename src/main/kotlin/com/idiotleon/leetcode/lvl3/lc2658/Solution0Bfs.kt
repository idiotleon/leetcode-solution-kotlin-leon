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
class Solution0Bfs {
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
                    visited[r][c] = true
                    val sum = bfs(r, c, grid, visited)
                    max = maxOf(max, sum)
                }
            }
        }

        return max
    }

    private fun bfs(r: Int, c: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        var sum = 0
        val queue = ArrayDeque<Node>(nRows * nCols).also {
            it.addLast(Node(r, c))
        }

        while (queue.isNotEmpty()) {
            val sizeQ = queue.size

            for (sz in 0 until sizeQ) {
                val (r, c) = queue.removeFirst()
                sum += grid[r][c]

                for (d in 0 until 4) {
                    val nextR = r + DIRS[d]
                    val nextC = c + DIRS[d + 1]
                    if (nextR !in 0 until nRows || nextC !in 0 until nCols || grid[nextR][nextC] == LAND || visited[nextR][nextC]) {
                        continue
                    }
                    queue.addLast(Node(nextR, nextC))
                    visited[nextR][nextC] = true
                }
            }
        }

        return sum
    }

    private data class Node(val r: Int = 0, val c: Int = 0)
}