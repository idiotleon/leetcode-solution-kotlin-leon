/**
 * https://leetcode.com/problems/the-maze/
 *
 * Time Complexity:     O(`totalRows` * `totalCols`)
 * Space Complexity:    O(`totalRows` * `totalCols`)
 */
package com.idiotleon.leetcode.lvl3.lc0490

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
        val nRows = maze.size
        val nCols = maze[0].size

        val queue = LinkedList<IntArray>().also {
            it.offer(start)
        }

        val visited = Array(nRows) { BooleanArray(nCols) { false } }
        val (startRow, startCol) = start
        visited[startRow][startCol] = true

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                cur?.let {
                    if (it contentEquals destination) return true
                }

                val curRow = cur[0]
                val curCol = cur[1]

                for (d in 0 until 4) {
                    var nextRow = curRow
                    var nextCol = curCol

                    while (isValid(nextRow + DIRS[d], nextCol + DIRS[d + 1], maze)) {
                        nextRow += DIRS[d]
                        nextCol += DIRS[d + 1]
                    }

                    if (visited[nextRow][nextCol]) continue

                    queue.offer(intArrayOf(nextRow, nextCol))
                    visited[nextRow][nextCol] = true
                }
            }
        }

        return false
    }

    private fun isValid(row: Int, col: Int, maze: Array<IntArray>): Boolean {
        val nRows = maze.size
        val nCols = maze[0].size

        return (row in 0 until nRows) && (col in 0 until nCols) && maze[row][col] == 0
    }
}