/**
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
 *
 * Time Complexity:     O(E + V)
 * Space Complexity:    O(E + V)
 *
 * References:
 *  https://leetcode.com/problems/all-paths-from-source-lead-to-destination/discuss/303566/Java-DFS-with-cycle-detection-(5ms)
 */
package com.zea7ot.leetcode.lvl3.lc1059

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val NOT_VISITED = 0
        private const val VISITING = 1
        private const val VISITED = 2
    }

    fun leadsToDestination(n: Int,
                           edges: Array<IntArray>,
                           source: Int,
                           destination: Int): Boolean {

        val graph = buildGraph(n, edges)

        val visited = IntArray(n) { NOT_VISITED }

        return dfs(source, visited, destination, graph)
    }

    private fun dfs(cur: Int,
                    visited: IntArray,
                    destination: Int,
                    graph: Array<MutableList<Int>>): Boolean {

        if (visited[cur] == VISITING) return false
        if (visited[cur] == VISITED) return true

        if (graph[cur].isEmpty()) return cur == destination

        visited[cur] = VISITING
        for (next in graph[cur]) {
            if (!dfs(next, visited, destination, graph)) return false
        }

        visited[cur] = VISITED
        return true
    }

    private fun buildGraph(nVertices: Int, edges: Array<IntArray>): Array<MutableList<Int>> {
        val graph = Array(nVertices) { mutableListOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge

            graph[u].add(v)
            // directed graph, this line cannot be added
            // graph[v].add(u)
        }

        return graph
    }
}