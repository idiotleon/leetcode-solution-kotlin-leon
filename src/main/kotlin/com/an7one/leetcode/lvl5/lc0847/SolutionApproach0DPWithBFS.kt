/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 *
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 *
 * References:
 *  https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135686/Java-DP-Solution
 */
package com.an7one.leetcode.lvl5.lc0847

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DPWithBFS {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val totalVertices = graph.size
        val fullMask = (1 shl totalVertices) - 1

        val queue = LinkedList<State>()
        val dp = Array(totalVertices) { vertex ->
            IntArray(fullMask + 1) { state ->
                when (state) {
                    1 shl vertex -> 0
                    else -> Int.MAX_VALUE
                }
            }.also {
                queue.offer(State(vertex, 1 shl vertex))
            }
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                val curVertex = cur.vertex
                val curBitMask = cur.bitMask

                for (nextVertex in graph[curVertex]) {
                    val nextBitMask = curBitMask or (1 shl nextVertex)

                    if (dp[nextVertex][nextBitMask] > dp[curVertex][curBitMask] + 1) {
                        dp[nextVertex][nextBitMask] = dp[curVertex][curBitMask] + 1
                        queue.offer(State(nextVertex, nextBitMask))
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