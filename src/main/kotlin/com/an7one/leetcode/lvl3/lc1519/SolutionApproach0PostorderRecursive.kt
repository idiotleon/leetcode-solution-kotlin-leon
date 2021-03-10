/**
 * https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/discuss/743133/Java-DFS.
 */
package com.an7one.leetcode.lvl3.lc1519

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val graph = buildGraph(n, edges)

        val ans = IntArray(n) { 0 }
        dfs(0, -1, labels, graph, ans)
        return ans
    }

    private fun dfs(
        cur: Int,
        parent: Int,
        labels: String,
        graph: Array<MutableList<Int>>,
        res: IntArray
    ): IntArray {
        val freqs = IntArray(26) { 0 }
        val ch = labels[cur]

        for (next in graph[cur]) {
            if (next == parent) continue

            val subTree = dfs(next, cur, labels, graph, res)
            for (idx in freqs.indices) {
                freqs[idx] += subTree[idx]
            }
        }

        res[cur] = ++freqs[ch - 'a']
        return freqs
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): Array<MutableList<Int>> {
        val graph = Array(n) { mutableListOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge

            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}