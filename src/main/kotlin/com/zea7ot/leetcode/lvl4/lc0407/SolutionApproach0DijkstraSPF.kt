/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 *
 * Time Complexity:     O(V + Elg(V)) ~
 * Space Complexity:    O(Elg(V)) ~
 *
 * References:
 *  https://leetcode.com/problems/trapping-rain-water-ii/discuss/89461/Java-solution-using-PriorityQueue
 */
package com.zea7ot.leetcode.lvl4.lc0407

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    private companion object {
        private val DIRS: IntArray = intArrayOf(0, -1, 0, 1, 0)
    }

    fun trapRainWater(heightMap: Array<IntArray>): Int {
        // sanity check
        if (heightMap.isEmpty() || heightMap[0].isEmpty()) return 0

        val sizeRow = heightMap.size
        val sizeCol = heightMap[0].size
        val visited = Array(sizeRow) { BooleanArray(sizeCol) { false } }

        val minHeap = PriorityQueue<Cell> { a, b -> a.height.compareTo(b.height) }

        for (col in 0 until sizeCol) {
            visited[0][col] = true
            minHeap.offer(Cell(0, col, heightMap[0][col]))
            visited[sizeRow - 1][col] = true
            minHeap.offer(Cell(sizeRow - 1, col, heightMap[sizeRow - 1][col]))
        }

        for (row in 1 until sizeRow - 1) {
            visited[row][0] = true
            minHeap.offer(Cell(row, 0, heightMap[row][0]))
            visited[row][sizeCol - 1] = true
            minHeap.offer(Cell(row, sizeCol - 1, heightMap[row][sizeCol - 1]))
        }

        var water = 0
        while (minHeap.isNotEmpty()) {
            val top = minHeap.poll()

            for (d in 0 until 4) {
                val nr = top.row + DIRS[d]
                val nc = top.col + DIRS[d + 1]

                if (nr < 0 || nr >= sizeRow || nc < 0 || nc >= sizeCol || visited[nr][nc]) continue
                visited[nr][nc] = true
                water += maxOf(0, top.height - heightMap[nr][nc])
                minHeap.offer(Cell(nr, nc, maxOf(top.height, heightMap[nr][nc])))
            }
        }

        return water
    }

    private data class Cell(val row: Int, val col: Int, val height: Int)
}