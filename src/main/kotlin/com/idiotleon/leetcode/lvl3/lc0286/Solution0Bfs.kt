package com.idiotleon.leetcode.lvl3.lc0286

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/walls-and-gates/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0Bfs {
    private companion object {
        private const val WALL = -1
        private const val GATE = 0
        private const val INF = 2147483647
        private const val EMPTY = INF

        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val nRows = rooms.size
        val nCols = rooms[0].size

        val queue = ArrayDeque<Node>(nRows * nCols).also {
            for (r in 0 until nRows) {
                for (c in 0 until nCols) {
                    if (rooms[r][c] == GATE) {
                        it.addLast(Node(r, c))
                    }
                }
            }
        }

        var step = 1
        while (queue.isNotEmpty()) {
            val sizeQ = queue.size
            for (sz in 0 until sizeQ) {
                val (curR, curC) = queue.removeFirst()

                for (d in 0 until 4) {
                    val nextR = curR + DIRS[d]
                    val nextC = curC + DIRS[d + 1]

                    if (nextR in 0 until nRows && nextC in 0 until nCols && rooms[nextR][nextC] == EMPTY) {
                        rooms[nextR][nextC] = step
                        queue.addLast(Node(nextR, nextC))
                    }
                }
            }

            ++step
        }
    }

    private data class Node(val r: Int, val c: Int)
}