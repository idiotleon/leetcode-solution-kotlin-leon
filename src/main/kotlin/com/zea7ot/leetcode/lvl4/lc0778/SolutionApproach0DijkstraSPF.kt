/**
 * https://leetcode.com/problems/swim-in-rising-water/
 *
 * Time Complexity:     O(E * lg(V))
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/swim-in-rising-water/discuss/113770/C++Python-PriorityQueue/119339
 *  https://leetcode.com/problems/swim-in-rising-water/discuss/113770/C%2B%2BPython-PriorityQueue
 */
package com.zea7ot.leetcode.lvl4.lc0778

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size

        val minHeap = PriorityQueue<Node>(compareBy { it.elevation })
        minHeap.offer(Node(0, 0, grid[0][0]))

        val visited = Array(n) { BooleanArray(n) { false } }

        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val curRow = cur.row
            val curCol = cur.col

            for (d in 0 until 4) {
                val nextRow = curRow + DIRS[d]
                val nextCol = curCol + DIRS[d + 1]

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue
                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true
                    val nextElevation = maxOf(cur.elevation, grid[nextRow][nextCol])
                    if (nextRow == n - 1 && nextCol == n - 1) return nextElevation
                    minHeap.offer(Node(nextRow, nextCol, nextElevation))
                }
            }
        }

        return -1
    }

    private data class Node(val row: Int, val col: Int, val elevation: Int)
}