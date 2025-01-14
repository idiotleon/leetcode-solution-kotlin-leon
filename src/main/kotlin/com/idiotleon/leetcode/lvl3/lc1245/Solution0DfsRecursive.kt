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
class Solution0DfsRecursive {
    fun treeDiameter(edges: Array<IntArray>): Int {
        val nVertices = edges.size + 1

        val graph = buildGraph(nVertices, edges)

        val node = Node(0, 0)
        dfs(0, -1, 0, graph, node)
        dfs(node.vertex, -1, 0, graph, node)

        return node.len
    }

    private fun dfs(
        cur: Int, parent: Int, len: Int, graph: List<List<Int>>, node: Node
    ) {
        if (len > node.len) {
            node.len = len
            node.vertex = cur
        }

        for (next in graph[cur]) {
            if (next == parent) {
                continue
            }

            dfs(next, cur, 1 + len, graph, node)
        }
    }

    private fun buildGraph(nVertices: Int, edges: Array<IntArray>): List<List<Int>> {
        val graph = List(nVertices) { mutableListOf<Int>() }

        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        return graph.map { it.toList() }
    }

    private data class Node(var len: Int, var vertex: Int)
}