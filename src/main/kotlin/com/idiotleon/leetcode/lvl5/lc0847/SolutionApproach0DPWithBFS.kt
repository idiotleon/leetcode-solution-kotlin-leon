package com.idiotleon.leetcode.lvl5.lc0847

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 *
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 *
 * Reference:
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135686/Java-DP-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0DPWithBFS {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val nVertices = graph.size
        val fullMask = (1 shl nVertices) - 1

        val queue = ArrayDeque<State>()
        val dp = Array(nVertices) { vertex ->
            IntArray(fullMask + 1) { state ->
                when (state) {
                    1 shl vertex -> 0
                    else -> Int.MAX_VALUE
                }
            }.also {
                queue.addLast(State(vertex, 1 shl vertex))
            }
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                val curVertex = cur.vertex
                val curBitMask = cur.bitMask

                for (nextVertex in graph[curVertex]) {
                    val nextBitMask = curBitMask or (1 shl nextVertex)

                    if (dp[nextVertex][nextBitMask] > dp[curVertex][curBitMask] + 1) {
                        dp[nextVertex][nextBitMask] = dp[curVertex][curBitMask] + 1
                        queue.addLast(State(nextVertex, nextBitMask))
                    }
                }
            }
        }

        var shortest = Integer.MAX_VALUE
        for (row in dp) {
            shortest = minOf(shortest, row.last())
        }

        return shortest
    }

    private data class State(val vertex: Int, val bitMask: Int) {
        fun toHash() = "$vertex#$bitMask"
    }
}