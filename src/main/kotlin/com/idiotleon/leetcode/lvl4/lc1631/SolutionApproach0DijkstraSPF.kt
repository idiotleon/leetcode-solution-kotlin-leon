package com.idiotleon.leetcode.lvl4.lc1631

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://zxi.mytechroad.com/blog/graph/leetcode-1631-path-with-minimum-effort/
 */
@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val nRows = heights.size
        val nCols = heights[0].size

        val minHeap = PriorityQueue<Vertex>(compareBy { it.effort })
        minHeap.offer(Vertex(0, 0, 0))

        // shortest distances
        val efforts = Array(nRows) { IntArray(nCols) { Int.MAX_VALUE } }
        efforts[0][0] = 0

        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val row = cur.row
            val col = cur.col

            if (row == nRows - 1 && col == nCols - 1) return cur.effort

            for (d in 0 until 4) {
                val nextRow = row + DIRS[d]
                val nextCol = col + DIRS[d + 1]

                if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols) continue

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