package com.idiotleon.leetcode.lvl3.lc1765

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/map-of-highest-peak/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0Bfs {
    private companion object {
        private const val WATER = 1

        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val nRows = isWater.size
        val nCols = isWater[0].size

        val visited = Array(nRows) { BooleanArray(nCols) { false } }
        val queue = ArrayDeque<Node>(nRows * nCols).also {
            for (r in 0 until nRows) {
                for (c in 0 until nCols) {
                    if (isWater[r][c] == WATER) {
                        it.addLast(Node(r, c))
                        visited[r][c] = true
                    }
                }
            }
        }

        val ans = Array(nRows) { IntArray(nCols) { 0 } }
        var step = 0
        while (queue.isNotEmpty()) {
            val sizeQ = queue.size
            for (sz in 0 until sizeQ) {
                val (curR, curC) = queue.removeFirst()
                ans[curR][curC] = step

                for (d in 0 until 4) {
                    val nextR = curR + DIRS[d]
                    val nextC = curC + DIRS[d + 1]

                    if (nextR in 0 until nRows && nextC in 0 until nCols && isWater[nextR][nextC] == 0 && !visited[nextR][nextC]) {
                        queue.addLast(Node(nextR, nextC))
                        visited[nextR][nextC] = true
                    }
                }
            }

            ++step
        }

        return ans
    }

    private data class Node(val r: Int, val c: Int)
}