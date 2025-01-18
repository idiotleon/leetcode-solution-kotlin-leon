package com.idiotleon.leetcode.lvl4.lc1368

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/editorial/?envType=daily-question&envId=2025-01-18
 */
@Suppress(UNUSED)
class Solution0DjikstraAlgorithm {
    private companion object {
        private val DIRS = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    }

    fun minCost(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val minHeap = PriorityQueue<Position>(compareBy { it.cost }).also {
            it.offer(Position())
        }

        val costs = Array(nRows) { IntArray(nCols) { Int.MAX_VALUE } }.also {
            it[0][0] = 0
        }

        while (minHeap.isNotEmpty()) {
            val (curR, curC, curCost) = minHeap.poll()
            if (costs[curR][curC] != curCost) {
                continue
            }

            for (d in 0 until 4) {
                val (deltaR, deltaC) = DIRS[d]
                val nextR = curR + deltaR
                val nextC = curC + deltaC

                if (nextR !in 0 until nRows || nextC !in 0 until nCols) {
                    continue
                }

                val nextCost = if (grid[curR][curC] != d + 1) {
                    curCost + 1
                }else{
                    curCost
                }
                if (costs[nextR][nextC] > nextCost) {
                    costs[nextR][nextC] = nextCost
                    minHeap.offer(Position(nextR, nextC, nextCost))
                }
            }
        }

        return costs[nRows - 1][nCols - 1]
    }

    private data class Position(val r: Int = 0, val c: Int = 0, val cost: Int = 0)
}