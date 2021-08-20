/**
 * @author: Leon
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Time Complexity:     O(V + E) ~ O(`n` + `nEdges`)
 * Space Complexity:    O(V + E) ~ O(`n` + `nEdges`)
 */
package com.an7one.leetcode.lvl2.lc1971

class SolutionApproach0DFSRecursive {
    fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        // not used
        // val nEdges = edges.size

        val graph = buildGraph(n, edges)
        val seen = HashSet<Int>().also {
            it.add(start)
        }
        return dfs(seen, start, end, graph)
    }

    private fun dfs(seen: HashSet<Int>, cur: Int, end: Int, graph: List<HashSet<Int>>): Boolean {
        if (cur == end) {
            return true
        }

        for (next in graph[cur]) {
            if (seen.add(next))
                if (dfs(seen, next, end, graph))
                    return true
        }

        return false
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): List<HashSet<Int>> {
        val graph = MutableList(n) { hashSetOf<Int>() }

        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}