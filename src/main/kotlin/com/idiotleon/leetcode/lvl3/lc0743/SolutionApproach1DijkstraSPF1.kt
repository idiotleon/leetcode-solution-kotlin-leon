package com.idiotleon.leetcode.lvl3.lc0743

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/network-delay-time/
 *
 * Time Complexity:     O(`nNodes` ^ 2)
 * Space Complexity:    O(`nNodes`)
 *
 * Plain Dijkstra's SPF, without optimization with a min heap, is comparably suitable for dense graphs
 *
 * Reference:
 * Paid Course: https://www.acwing.com/video/24/
 * https://leetcode-cn.com/problems/network-delay-time/solution/dan-yuan-zui-duan-lu-po-su-de-dijkstra-dui-you-hua/
 */
@Suppress(UNUSED)
class SolutionApproach1DijkstraSPF1 {
    private companion object {
        private const val DATA_RANGE = 100 + 1
    }

    fun networkDelayTime(times: Array<IntArray>, nNodes: Int, start: Int): Int {
        val graph = buildGraph(times, nNodes)
        val distances = IntArray(nNodes + 1) { DATA_RANGE }.also { it[start] = 0 }
        val shortestPathFound = BooleanArray(nNodes + 1) { false }

        for (i in 0 until nNodes - 1) {
            var t = -1
            for (j in 1..nNodes) {
                if (!shortestPathFound[j] && (t == -1 || distances[t] > distances[j])) {
                    t = j
                }
            }

            shortestPathFound[t] = true

            for (j in 1..nNodes) {
                distances[j] = minOf(distances[j], distances[t] + graph[t][j])
            }
        }

        var shortest = Int.MIN_VALUE
        for (idx in 1..nNodes) {
            shortest = maxOf(shortest, distances[idx])
        }

        return if (shortest == DATA_RANGE) -1 else shortest
    }

    private fun buildGraph(times: Array<IntArray>, nNodes: Int): Array<IntArray> {
        val graph = Array(nNodes + 1) { IntArray(nNodes + 1) { DATA_RANGE } }

        for ((start, end, time) in times) {
            graph[start][end] = time
        }

        return graph
    }
}