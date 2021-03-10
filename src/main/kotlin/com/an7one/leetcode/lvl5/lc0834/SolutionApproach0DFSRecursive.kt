/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/
 *
 * Time Complexity:     O(`totalNodes`)
 * Space Complexity:    O(`totalNodes`)
 *
 * References:
 *  https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and-Post-order-DFS-O(N)
 */
package com.an7one.leetcode.lvl5.lc0834

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun sumOfDistancesInTree(nNodes: Int, edges: Array<IntArray>): IntArray {
        val distances = IntArray(nNodes)
        val counts = IntArray(nNodes)

        val graph = buildGraph(edges, nNodes)

        postorder(-1, 0, counts, graph, distances)
        preorder(-1, 0, counts, graph, nNodes, distances)

        return distances
    }

    private fun postorder(prev: Int, cur: Int, counts: IntArray, graph: Array<HashSet<Int>>, distances: IntArray) {
        for (next in graph[cur]) {
            if (next == prev) continue

            postorder(cur, next, counts, graph, distances)
            counts[cur] += counts[next]
            distances[cur] += distances[next] + counts[next]
        }

        ++counts[cur]
    }

    private fun preorder(
        prev: Int,
        cur: Int,
        counts: IntArray,
        graph: Array<HashSet<Int>>,
        nNodes: Int,
        distances: IntArray
    ) {
        for (next in graph[cur]) {
            if (next == prev) continue

            distances[next] = distances[cur] - counts[next] + nNodes - counts[next]
            preorder(cur, next, counts, graph, nNodes, distances)
        }
    }

    private fun buildGraph(edges: Array<IntArray>, totalNodes: Int): Array<HashSet<Int>> {
        val graph = Array(totalNodes) { hashSetOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge

            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}