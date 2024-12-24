package com.idiotleon.leetcode.lvl4.lc3203

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
 *
 * Time Complexity:     O(U + V) ~ O(`nEdges1` + `nEdges2`) ~ O(maxOf(`nEdges1`, `nEdges2`))
 * Space Complexity:    O(U + V) ~ O(`nEdges1` + `nEdges2`) ~ O(maxOf(`nEdges1`, `nEdges2`))
 *
 * Reference:
 * https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/solutions/5389408/simple-java-solution-dfs-100-fast-by-ron-9569/
 */
@Suppress(UNUSED)
class Solution0DfsRecursive {
    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
        val nEdges1 = edges1.size
        val nEdges2 = edges2.size

        val graph1 = buildGraph(edges1)
        val diameter1 = getDiameter(graph1)

        val graph2 = buildGraph(edges2)
        val diameter2 = getDiameter(graph2)

        return maxOf(diameter1, diameter2, (diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1)
    }

    private fun buildGraph(edges: Array<IntArray>): List<List<Int>> {
        val nEdges = edges.size
        val graph = List(nEdges + 1) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }
        return graph
    }

    private fun getDiameter(graph: List<List<Int>>): Int {
        val (firstFurthest, firstLongest) = dfs(0, -1, graph)
        val (secondFurthest, secondLongest) = dfs(firstFurthest, -1, graph)
        return secondLongest
    }

    // postorder
    private fun dfs(cur: Int, prev: Int, graph: List<List<Int>>): Res {
        var furthest = cur
        var longest = 0

        for (next in graph[cur]) {
            if (next == prev) {
                continue
            }
            val (furthestNext, longestNext) = dfs(next, cur, graph)
            if (longestNext + 1 > longest) {
                longest = 1 + longestNext
                furthest = furthestNext
            }
        }

        return Res(furthest, longest)
    }

    private data class Res(val furthestNode: Int, val longest: Int)
}