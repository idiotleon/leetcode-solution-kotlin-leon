/**
 * @author: Leon
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 * Time Complexity:     O(V * E) ~ O()
 * Space Complexity:    O(V) ~ O()
 */
package com.zea7ot.leetcode.lvl4.lc1631

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach1BellmanFord {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val totalRows = heights.size
        val totalCols = heights[0].size

        val queue = LinkedList<Vertex>()
        queue.offer(Vertex(0, 0, 0))

        // shortest distances
        val efforts = Array(totalRows) { IntArray(totalCols) { Int.MAX_VALUE } }
        efforts[0][0] = 0

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val row = cur.row
            val col = cur.col

            for (d in 0 until 4) {
                val nextRow = row + DIRS[d]
                val nextCol = col + DIRS[d + 1]

                if (nextRow < 0 || nextRow >= totalRows || nextCol < 0 || nextCol >= totalCols) continue

                val newEffort = Math.abs(heights[row][col] - heights[nextRow][nextCol])
                val nextEffort = maxOf(cur.effort, newEffort)
                if (nextEffort < efforts[nextRow][nextCol]) {
                    queue.offer(Vertex(nextRow, nextCol, nextEffort))
                    efforts[nextRow][nextCol] = nextEffort
                }
            }
        }

        return efforts.last().last()
    }

    private data class Vertex(val row: Int, val col: Int, val effort: Int)
}