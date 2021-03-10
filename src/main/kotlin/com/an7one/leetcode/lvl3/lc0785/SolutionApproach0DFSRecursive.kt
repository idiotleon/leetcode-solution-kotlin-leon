/**
 * @author: Leon
 * https://leetcode.com/problems/is-graph-bipartite/
 *
 * Time Complexity:     O(V + E) + O(N) ~ O(2 * N) + O(N) ~ O(N)
 * Space Complexity:    O(V + E) + O(N) ~ O(2 * N) + O(N) ~ O(N)
 */
package com.an7one.leetcode.lvl3.lc0785

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val NOT_COLORED = 0
        private const val COLORED = 1
    }

    fun isBipartite(graph: Array<IntArray>): Boolean {
        val nVertices = graph.size

        val colors = IntArray(nVertices) { NOT_COLORED }

        for (vertex in graph.indices) {
            if (colors[vertex] == NOT_COLORED) {
                if (!isBipartite(vertex, COLORED, colors, graph)) return false
            }
        }

        return true
    }

    private fun isBipartite(cur: Int, expectedColor: Int, colors: IntArray, graph: Array<IntArray>): Boolean {
        if (colors[cur] != NOT_COLORED) {
            return colors[cur] == expectedColor
        }

        colors[cur] = expectedColor
        for (next in graph[cur]) {
            if (!isBipartite(next, -expectedColor, colors, graph)) return false
        }

        return true
    }
}