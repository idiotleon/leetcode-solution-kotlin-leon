package com.idiotleon.leetcode.lvl3.lc0310

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

import kotlin.collections.ArrayDeque;

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-height-trees/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-height-trees/discuss/76129/Share-my-BFS-JAVA-code-using-degree-with-explanation-which-beats-more-than-95/293110
 */
@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return mutableListOf(0)

        val degrees = IntArray(n) { 0 }
        val graph = buildGraph(degrees, n, edges)

        val queue = ArrayDeque<Int>()
        for ((idxNode, degree) in degrees.withIndex()) {
            if (degree == 1) {
                queue.addLast(idxNode)
            }
        }

        var ans = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            val newLeaves = mutableListOf<Int>()

            for (_sz in 0 until size) {
                val cur = queue.removeFirst()
                newLeaves.add(cur)

                for (next in graph[cur]) {
                    if (--degrees[next] == 1) {
                        queue.addLast(next)
                    }
                }
            }

            ans = newLeaves
        }

        return ans
    }

    private fun buildGraph(degrees: IntArray, n: Int, edges: Array<IntArray>): Array<ArrayList<Int>> {
        val graph = Array(n) { arrayListOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge

            graph[u].add(v)
            graph[v].add(u)

            ++degrees[u]
            ++degrees[v]
        }

        return graph
    }
}