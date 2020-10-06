/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/
 *
 * Time Complexity:     O(`totalNodes`)
 * Space Complexity:    O(`totalNodes`)
 *
 * References:
 *  https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and-Post-order-DFS-O(N)
 */
package com.zea7ot.leetcode.lvl5.lc0834

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun sumOfDistancesInTree(totalNodes: Int, edges: Array<IntArray>): IntArray {
        val distances = IntArray(totalNodes)
        val counts = IntArray(totalNodes)

        val graph = buildGraph(edges, totalNodes)

        postorder(0, -1, counts, graph, distances)
        preorder(0, -1, counts, graph, totalNodes, distances)

        return distances
    }

    private fun postorder(cur: Int, prev: Int, counts: IntArray, graph: Array<HashSet<Int>>, distances: IntArray) {
        for (next in graph[cur]) {
            if (next == prev) continue

            postorder(next, cur, counts, graph, distances)
            counts[cur] += counts[next]
            distances[cur] += distances[next] + counts[next]
        }

        ++counts[cur]
    }

    private fun preorder(cur: Int, prev: Int, counts: IntArray, graph: Array<HashSet<Int>>, totalNodes: Int, distances: IntArray) {
        for (next in graph[cur]) {
            if (next == prev) continue

            distances[next] = distances[cur] - counts[next] + totalNodes - counts[next]
            preorder(next, cur, counts, graph, totalNodes, distances)
        }
    }

    private fun buildGraph(edges: Array<IntArray>, totalNodes: Int): Array<HashSet<Int>> {
        val graph = Array(totalNodes) { hashSetOf<Int>() }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]

            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}