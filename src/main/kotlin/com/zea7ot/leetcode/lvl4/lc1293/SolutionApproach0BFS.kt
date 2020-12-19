/**
 * https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 *
 * Time Complexity:     O(`totalRows` * `totalCols`)
 * Space Complexity:    O(`totalRows` * `totalCols`)
 *
 * References:
 *  https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/discuss/451787/Python-O(m*n*k)-BFS-Solution-with-Explanation/732304
 */
package com.zea7ot.leetcode.lvl4.lc1293

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private val DIRS = arrayOf(0, -1, 0, 1, 0)

        // not used
        // private const val EMPTY = 0
        private const val OBSTACLE = 1
    }

    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val seen = Array(nRows) { Array<Int?>(nCols) { null } }
        val queue = LinkedList<Node>().also {
            it.offer(Node(0, 0, k))
        }

        var steps = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val cur = queue.poll()
                val row = cur.row
                val col = cur.col
                val kCur = cur.k
                // to return `steps` after reaching the destination
                if (row == nRows - 1 && col == nCols - 1) return steps

                for (d in 0 until 4) {
                    val newRow = row + DIRS[d]
                    val newCol = col + DIRS[d + 1]

                    if (newRow < 0 || newRow >= nRows || newCol < 0 || newCol >= nCols) continue
                    val kLeft = if (grid[newRow][newCol] == OBSTACLE) kCur - 1 else kCur

                    // equivalently
                    // if (kLeft < 0 || (seen[newRow][newCol] != null && seen[newRow][newCol] >= kLeft) continue
                    if (kLeft < 0 || (seen[newRow][newCol] ?: Int.MIN_VALUE) >= kLeft) continue

                    // or equivalently
                    // if(kLeft >= 0 && (seen[newRow][newCol] == null || seen[newRow][newCol]!! < kLeft)
                    //  if (kLeft >= 0 && ((seen[newRow][newCol] ?: Int.MIN_VALUE) < kLeft)) {
                    seen[newRow][newCol] = kLeft
                    queue.offer(Node(newRow, newCol, kLeft))
                    // }
                }
            }

            ++steps
        }

        return -1
    }

    private data class Node(val row: Int, val col: Int, val k: Int)
}