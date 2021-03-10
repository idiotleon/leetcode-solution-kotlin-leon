/**
 * https://leetcode.com/problems/the-maze-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/the-maze-ii/discuss/98393/simple-C++-BFS-using-queue/221931
 *  https://leetcode.com/problems/the-maze-ii/discuss/98393/simple-C%2B%2B-BFS-using-queue
 */
package com.an7one.leetcode.lvl4.lc0505

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0SPFA {
    private companion object {
        private const val EMPTY = 0
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray): Int {
        val nRows = maze.size
        val nCols = maze[0].size

        val (startRow, startCol) = start

        val queue = LinkedList<State>().also {
            it.offer(State(startRow, startCol, 0))
        }

        val distances = Array(nRows) { IntArray(nCols) { -1 } }.also {
            it[startRow][startCol] = 0
        }

        while (queue.isNotEmpty()) {
            val (curRow, curCol, curDistance) = queue.poll()

            for (d in 0 until 4) {
                var nextRow = curRow
                var nextCol = curCol
                var distance = 0

                while (isValid(nextRow + DIRS[d], nextCol + DIRS[d + 1], maze)) {
                    nextRow += DIRS[d]
                    nextCol += DIRS[d + 1]
                    ++distance
                }

                val nextDistance = curDistance + distance
                if (distances[nextRow][nextCol] == -1 || nextDistance < distances[nextRow][nextCol]) {
                    distances[nextRow][nextCol] = nextDistance
                    queue.offer(State(nextRow, nextCol, nextDistance))
                }
            }
        }

        val (destRow, destCol) = destination
        return distances[destRow][destCol]
    }

    private fun isValid(row: Int, col: Int, maze: Array<IntArray>): Boolean {
        val nRows = maze.size
        val nCols = maze[0].size

        return (row in 0 until nRows) && (col in 0 until nCols) && maze[row][col] == EMPTY
    }

    private data class State(val row: Int, val col: Int, val distance: Int)
}