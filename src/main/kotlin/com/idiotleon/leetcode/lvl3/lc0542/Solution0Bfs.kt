package com.idiotleon.leetcode.lvl3.lc0542

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/01-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0Bfs {
    private companion object {
        private const val ZERO = 0
        private const val ONE = 1

        private const val NOT_VISITED = -1

        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val nRows = matrix.size
        val nCols = matrix[0].size

        val queue = ArrayDeque<Node>(nRows * nCols)
        val ans = Array(nRows) { IntArray(nCols) { NOT_VISITED } }
        for (r in 0 until nRows) {
            for (c in 0 until nCols) {
                if (matrix[r][c] == ZERO) {
                    queue.addLast(Node(r, c))
                    ans[r][c] = 0
                }
            }
        }

        var step = 1
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (sz in 0 until size) {
                val (curR, curC) = queue.removeFirst()

                for (d in 0 until 4) {
                    val nextR = curR + DIRS[d]
                    val nextC = curC + DIRS[d + 1]

                    if (nextR in 0 until nRows && nextC in 0 until nCols && matrix[nextR][nextC] == ONE && ans[nextR][nextC] == NOT_VISITED) {
                        ans[nextR][nextC] = step
                        queue.addLast(Node(nextR, nextC))
                    }
                }
            }
            ++step
        }

        return ans
    }

    private data class Node(val r: Int, val c: Int)
}