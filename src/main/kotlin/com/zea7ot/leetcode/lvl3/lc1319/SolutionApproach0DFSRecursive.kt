/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * Time Complexity:     O(`n` + `nConn`)
 * Space Complexity:    O(`n` + `nConn`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-operations-to-make-network-connected/discuss/477660/Java-Count-number-of-connected-components-Clean-code
 */
package com.zea7ot.leetcode.lvl3.lc1319

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        val nConn = connections.size
        // sanity check, required
        if (nConn < n - 1) return -1

        val graph = buildGraph(n, connections)

        val visited = BooleanArray(n) { false }
        var components = 0

        for (vertex in 0 until n) {
            components += dfs(vertex, visited, graph)
        }

        return components - 1
    }

    private fun dfs(cur: Int,
                    visited: BooleanArray,
                    graph: Array<MutableList<Int>>): Int {

        if (visited[cur]) return 0

        visited[cur] = true
        for (next in graph[cur]) {
            dfs(next, visited, graph)
        }

        return 1
    }

    private fun buildGraph(nVertices: Int, edges: Array<IntArray>): Array<MutableList<Int>> {
        val graph = Array(nVertices) { mutableListOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge

            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}