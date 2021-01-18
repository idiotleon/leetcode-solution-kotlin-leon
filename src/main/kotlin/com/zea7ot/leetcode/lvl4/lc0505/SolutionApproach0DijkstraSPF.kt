/**
 * https://leetcode.com/problems/the-maze-ii/
 *
 * Time Complexity:     O(V + Elg(V)) ~ O(`totalRows` * `totalCols` * lg(`totalRows` * `totalCols`))
 * Space Complexity:    O(Elg(V)) ~ O(`totalRows` * `totalCols`)
 *
 * to find the next shortest stop from the starting point and then continue to explore from there.
 *
 * References:
 *  https://leetcode.com/problems/the-maze-ii/solution/
 */
package com.zea7ot.leetcode.lvl4.lc0505

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)

        private const val EMPTY = 0
        // not used
        // private const val WALL = 1
    }

    fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray): Int {
        val nRows = maze.size
        val nCols = maze[0].size

        val distances = Array(nRows) { row ->
            IntArray(nCols) { col ->
                when {
                    row == start[0] && col == start[1] -> 0
                    else -> Int.MAX_VALUE
                }
            }
        }

        val minHeap = PriorityQueue<State>(compareBy { it.distance })
        minHeap.offer(State(start[0], start[1], 0))

        while (minHeap.isNotEmpty()) {
            val (curRow, curCol, curDistance) = minHeap.poll()
            if (curRow == destination[0] && curCol == destination[1]) break

            for (d in 0 until 4) {
                var nextRow = curRow
                var nextCol = curCol
                var steps = 0

                while (isValid(nextRow + DIRS[d], nextCol + DIRS[d + 1], maze)) {
                    nextRow += DIRS[d]
                    nextCol += DIRS[d + 1]
                    ++steps
                }

                val nextDistance = curDistance + steps
                if (distances[nextRow][nextCol] > nextDistance) {
                    distances[nextRow][nextCol] = nextDistance
                    minHeap.offer(State(nextRow, nextCol, nextDistance))
                }
            }
        }

        return distances[destination[0]][destination[1]].let {
            if (it == Int.MAX_VALUE) -1 else it
        }
    }

    private fun isValid(row: Int, col: Int, maze: Array<IntArray>): Boolean {
        val nRows = maze.size
        val nCols = maze[0].size

        return (row in 0 until nRows) && (col in 0 until nCols) && maze[row][col] == EMPTY
    }

    private data class State(val row: Int, val col: Int, val distance: Int)
}