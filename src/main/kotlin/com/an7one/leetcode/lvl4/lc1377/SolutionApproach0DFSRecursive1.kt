package com.an7one.leetcode.lvl4.lc1377

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
        val graph = buildGraph(n, edges)
        return dfs(1, t, 1.0, target, graph)
    }

    private fun dfs(
        cur: Int,
        time: Int,
        probability: Double,
        target: Int,
        graph: Array<HashSet<Int>>
    ): Double {

        if (time < 0) return 0.0

        if (cur == target && (time == 0 || graph[cur].isEmpty()))
            return probability

        val cntNextVertices = graph[cur].size
        for (next in graph[cur]) {
            graph[next].remove(cur)
            val res = dfs(next, time - 1, probability / cntNextVertices, target, graph)

            if (res != 0.0) return res
        }

        return 0.0
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): Array<HashSet<Int>> {
        val graph = Array(n + 1) { hashSetOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge

            // to keep 1-indexed vertices
            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}