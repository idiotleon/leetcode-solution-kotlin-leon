/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://zxi.mytechroad.com/blog/graph/leetcode-1631-path-with-minimum-effort/
 */
package com.zea7ot.leetcode.lvl4.lc1631

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val totalRows = heights.size
        val totalCols = heights[0].size

        val minHeap = PriorityQueue<Vertex>(compareBy { it.effort })
        minHeap.offer(Vertex(0, 0, 0))

        // shortest distances
        val efforts = Array(totalRows) { IntArray(totalCols) { Int.MAX_VALUE } }
        efforts[0][0] = 0

        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val row = cur.row
            val col = cur.col

            if (row == totalRows - 1 && col == totalCols - 1) return cur.effort

            for (d in 0 until 4) {
                val nextRow = row + DIRS[d]
                val nextCol = col + DIRS[d + 1]

                if (nextRow < 0 || nextRow >= totalRows || nextCol < 0 || nextCol >= totalCols) continue

                val newEffort = abs(heights[row][col] - heights[nextRow][nextCol])
                val nextEffort = maxOf(cur.effort, newEffort)
                if (nextEffort < efforts[nextRow][nextCol]) {
                    minHeap.offer(Vertex(nextRow, nextCol, nextEffort))
                    efforts[nextRow][nextCol] = nextEffort
                }
            }
        }

        return -1
    }

    private data class Vertex(val row: Int, val col: Int, val effort: Int)
}