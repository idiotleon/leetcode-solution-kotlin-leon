/**
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 *
 * Time Complexity:     O(E * lg(V)) ~ O(`totalRows` * `totalCols` * lg(`totalRows` * `totalCols`))
 * Space Complexity:    O(V) ~ O(`totalRows` * `totalCols`)
 *
 * References:
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/416227/Python-Dijkstra-Binary-Search-%2B-DFS-Union-Find-complexity-analysis
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/324923/Clear-Code-Dijkstra-Algorithm-(C%2B%2BJavaPythonGoPHP)
 */
package com.zea7ot.leetcode.lvl4.lc1102

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    private companion object {
        private val DIRS = arrayOf(0, 1, 0, -1, 0)
    }

    fun maximumMinimumPath(nums: Array<IntArray>): Int {
        val totalRows = nums.size
        val totalCols = nums[0].size

        val scores = Array(totalRows) { IntArray(totalCols) { -1 } }

        val maxHeap = PriorityQueue<Vertex>(compareBy { -it.score })
        maxHeap.offer(Vertex(0, 0, nums[0][0]))

        while (maxHeap.isNotEmpty()) {
            val cur = maxHeap.poll()
            val row = cur.row
            val col = cur.col

            if (row == totalRows - 1 && col == totalCols - 1) return cur.score

            for (d in 0 until 4) {
                val nextRow = row + DIRS[d]
                val nextCol = col + DIRS[d + 1]

                if (nextRow < 0 || nextRow >= totalRows || nextCol < 0 || nextCol >= totalCols) continue

                val score = minOf(nums[nextRow][nextCol], cur.score)
                if (score > scores[nextRow][nextCol]) {
                    scores[nextRow][nextCol] = score
                    maxHeap.offer(Vertex(nextRow, nextCol, score))
                }
            }
        }

        return -1
    }

    private data class Vertex(val row: Int, val col: Int, val score: Int)
}