package com.idiotleon.leetcode.lvl3.lc1091

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0Bfs {
    private companion object {
        private val DIRS = arrayOf(
            Node(0, 1), Node(0, -1), Node(-1, 0), Node(-1, -1), Node(-1, 1), Node(1, 0), Node(1, 1), Node(1, -1)
        )
    }

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        // edge case
        if (grid[0][0] != 0) {
            return -1
        }

        val queue = ArrayDeque<Node>().also {
            it.addLast(Node(0, 0))
        }
        val visited = Array(nRows) { BooleanArray(nCols) { false } }.also {
            it[0][0] = true
        }

        var step = 0
        while (queue.isNotEmpty()) {
            val lenQ = queue.size

            for (sz in 0 until lenQ) {
                val (curRow, curCol) = queue.removeFirst()
                if (curRow == nRows - 1 && curCol == nCols - 1) {
                    return step + 1
                }

                for ((deltaRow, deltaCol) in DIRS) {
                    val nextRow = curRow + deltaRow
                    val nextCol = curCol + deltaCol

                    if (nextRow in 0 until nRows && nextCol in 0 until nCols && grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                        queue.addLast(Node(nextRow, nextCol))
                        visited[nextRow][nextCol] = true
                    }
                }
            }

            ++step
        }

        return -1
    }

    private data class Node(val row: Int, val col: Int)
}