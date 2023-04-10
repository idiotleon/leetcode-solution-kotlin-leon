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
 * https://leetcode-cn.com/problems/network-delay-time/solution/dan-yuan-zui-duan-lu-po-su-de-dijkstra-dui-you-hua/
 */
@Suppress(UNUSED)
class SolutionApproach1DijkstraSPF {
    private companion object {
        private const val DATA_RANGE = 100 + 1
    }

    fun networkDelayTime(times: Array<IntArray>, nVertices: Int, start: Int): Int {
        val graph = buildGraph(times, nVertices)
        // shortest paths to the origin,
        // initialized with the starting vertex, 0-indexed
        val distances = IntArray(nVertices) { DATA_RANGE }.also { it[start - 1] = 0 }
        // whether the shortest path has been found or not
        val shortestPathFound = BooleanArray(nVertices) { false }

        for (i in distances.indices) {
            var temp = -1
            // to find the shortest path among all the vertices whose shortest paths have NOT been found
            for (j in distances.indices) {
                if (!shortestPathFound[j] && (temp == -1 || distances[temp] > distances[j])) {
                    temp = j
                }
            }

            shortestPathFound[temp] = true // the shortest path of `temp` vertex has been found

            for (idx in distances.indices) {
                distances[idx] = minOf(distances[idx], distances[temp] + graph[temp][idx])
            }
        }

        // in order to get the delay time,
        // the maximum distance of all shortest paths needs to be covered
        val shortest = distances.maxOrNull()!!
        return if (shortest == DATA_RANGE) -1 else shortest
    }

    private fun buildGraph(times: Array<IntArray>, nNodes: Int): Array<IntArray> {
        val graph = Array(nNodes) { IntArray(nNodes) { DATA_RANGE } }

        for ((start, end, time) in times) {
            graph[start - 1][end - 1] = time
        }

        return graph
    }
}