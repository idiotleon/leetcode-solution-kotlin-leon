/**
 * https://leetcode.com/problems/possible-bipartition/
 *
 * Time Complexity:     O(V + E) ~ O(N + dislikes.length)
 * Space Complexity:    O(V + E) ~ O(N + dislikes.length)
 *
 * References:
 *  https://leetcode.com/problems/possible-bipartition/discuss/158957/Java-DFS-solution
 */
package com.zea7ot.leetcode.lvl3.lc0886

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val NOT_COLORED = 0
        private const val COLORED = 1
    }

    fun possibleBipartition(nPeople: Int, dislikes: Array<IntArray>): Boolean {

        val graph = buildGraph(nPeople, dislikes)
        val colors = IntArray(nPeople + 1) { NOT_COLORED }

        for (vertex in 1 until nPeople) {
            if (colors[vertex] == NOT_COLORED)
                if (!dfs(vertex, COLORED, colors, graph)) return false
        }

        return true
    }

    // can bipartite
    private fun dfs(
        cur: Int,
        expectedColor: Int,
        colors: IntArray,
        graph: Array<MutableList<Int>>
    ): Boolean {

        if (colors[cur] != NOT_COLORED) {
            return colors[cur] == expectedColor
        }

        colors[cur] = expectedColor

        for (next in graph[cur]) {
            if (!dfs(next, -expectedColor, colors, graph)) return false
        }

        return true
    }

    private fun buildGraph(nPeople: Int, dislikes: Array<IntArray>): Array<MutableList<Int>> {
        val graph = Array(nPeople + 1) { mutableListOf<Int>() }

        for (edge in dislikes) {
            val (u, v) = edge

            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}