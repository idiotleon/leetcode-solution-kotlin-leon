/**
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 *
 * Time Complexity:     O(V * E) ~ O((`totalRows` * `totalCols`) ^ 2)
 * Space Complexity:    O(V) ~ O(`totalRows` * `totalCols`)
 *
 * References:
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/519291/my-cpp-dfs-brute-force-solution-binary-search-bfs-%2B-bellman-ford-and-bfs-%2B-dijkstra
 */
package com.idiotleon.leetcode.lvl4.lc1102

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach1BellmanFord {
    private companion object {
        private val DIRS = arrayOf(0, -1, 0, 1, 0)
    }

    fun maximumMinimumPath(nums: Array<IntArray>): Int {
        val totalRows = nums.size
        val totalCols = nums[0].size

        val scores = Array(totalRows) { IntArray(totalCols) { -1 } }
        // can be omitted, but why?!
        // scores[0][0] = nums[0][0]

        val queue = LinkedList<Vertex>()
        queue.offer(Vertex(0, 0, nums[0][0]))

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val row = cur.row
            val col = cur.col

            for (d in 0 until 4) {
                val nextRow = row + DIRS[d]
                val nextCol = col + DIRS[d + 1]

                if (nextRow < 0 || nextRow >= totalRows || nextCol < 0 || nextCol >= totalCols) continue

                val min = minOf(cur.score, nums[nextRow][nextCol])
                if (scores[nextRow][nextCol] == -1 || scores[nextRow][nextCol] < min) {
                    scores[nextRow][nextCol] = min
                    queue.push(Vertex(nextRow, nextCol, min));
                }
            }
        }

        return scores.last().last();
        // or equivalently
        // return scores[totalRows - 1][totalCols - 1]
    }

    private data class Vertex(val row: Int, val col: Int, val score: Int)
}