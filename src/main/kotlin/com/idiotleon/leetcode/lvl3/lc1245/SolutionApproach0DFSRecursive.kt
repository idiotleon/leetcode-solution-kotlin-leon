package com.idiotleon.leetcode.lvl3.lc1245

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/tree-diameter/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/tree-diameter/discuss/418820/(Java)-Using-2-BFS
 * https://leetcode.com/problems/tree-diameter/discuss/418820/(Java)-Using-2-BFS/402688
 * https://stackoverflow.com/a/29219346/6061609
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun treeDiameter(edges: Array<IntArray>): Int {
        val nVertices = edges.size + 1

        val graph = buildGraph(nVertices, edges)

        val res = Res(0, 0)
        dfs(0, -1, 0, graph, res)
        dfs(res.vertex, -1, 0, graph, res)

        return res.len
    }

    private fun dfs(
        cur: Int, parent: Int, len: Int, graph: Array<MutableList<Int>>, res: Res
    ) {
        if (len > res.len) {
            res.len = len
            res.vertex = cur
        }

        for (next in graph[cur]) {
            if (next == parent) continue
            dfs(next, cur, 1 + len, graph, res)
        }
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

    private data class Res(var len: Int, var vertex: Int)
}