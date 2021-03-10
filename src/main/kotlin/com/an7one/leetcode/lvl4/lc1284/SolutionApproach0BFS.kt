/**
 * https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
 *
 * Time Complexity:     O(`totalRows` * `totalCols` * (2 ^ (`totalRows` * `totalCols`)))
 * Space Complexity:    O(2 ^ (`totalRows` * `totalCols`))
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/discuss/446342/JavaPython-3-Convert-matrix-to-int%3A-BFS-and-DFS-codes-w-explanation-comments-and-analysis.
 */
package com.an7one.leetcode.lvl4.lc1284

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private val DIRS = arrayOf(0, 0, -1, 0, 1, 0)
    }

    fun minFlips(matrix: Array<IntArray>): Int {
        val totalRows = matrix.size
        val totalCols = matrix[0].size

        // bit mask
        var start = 0
        for (row in 0 until totalRows) {
            for (col in 0 until totalCols) {
                start = start or (matrix[row][col] shl (row * totalCols + col))
            }
        }

        val queue = LinkedList<Int>()
        queue.offer(start)

        val seen = hashSetOf(start)

        var steps = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                if (cur == 0) return steps

                for (row in 0 until totalRows) {
                    for (col in 0 until totalCols) {
                        var next = cur

                        for (d in 0 until 5) {
                            val nextRow = row + DIRS[d]
                            val nextCol = col + DIRS[d + 1]

                            if (nextRow < 0 || nextRow >= totalRows || nextCol < 0 || nextCol >= totalCols) continue

                            next = next xor (1 shl (nextRow * totalCols + nextCol))
                        }

                        if (!seen.add(next)) continue
                        queue.offer(next)
                    }
                }
            }

            ++steps
        }

        return -1
    }
}