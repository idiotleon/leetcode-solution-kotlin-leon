/**
 * https://leetcode.com/problems/minimum-height-trees/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-height-trees/discuss/76129/Share-my-BFS-JAVA-code-using-degree-with-explanation-which-beats-more-than-95/293110
 */
package com.zea7ot.leetcode.lvl3.lc0310

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

import kotlin.collections.ArrayList

@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return arrayListOf(0)

        val degrees = IntArray(n) { 0 }
        val graph = buildGraph(degrees, n, edges)

        val queue = LinkedList<Int>()
        for (vertex in degrees.indices) {
            if (degrees[vertex] == 1) {
                queue.offer(vertex)
            }
        }

        var ans = ArrayList<Int>()
        while (queue.isNotEmpty()) {
            val size = queue.size

            val newLeaves = ArrayList<Int>()
            for (sz in 0 until size) {
                val cur = queue.poll()
                newLeaves.add(cur)

                for (next in graph[cur]) {
                    if (--degrees[next] == 1) {
                        queue.offer(next)
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