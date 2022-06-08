package com.an7one.leetcode.lvl4.lc1857

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
 *
 * Time Complexity:     O(V + E) ~ O(`lenC` + `nEdges`)
 * Space Complexity:    O(V + E) ~ O(`lenC` + `nEdges`)
 *
 * Reference:
 *  https://leetcode.com/problems/largest-color-value-in-a-directed-graph/discuss/1198658/C++-Topological-Sort/931674
 *  https://leetcode.com/problems/largest-color-value-in-a-directed-graph/discuss/1198658/C%2B%2B-Topological-Sorts
 */
@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        // also serves as the number of vertices
        val lenC = colors.length

        // not used
        // val nEdges = edges.size

        val (graph, indegrees) = buildGraph(lenC, edges)

        val chToChFreqs = Array(lenC) { IntArray(26) }

        val queue = LinkedList<Int>()
        for ((idx, indegree) in indegrees.withIndex()) {
            if (indegree == 0) {
                queue.offer(idx)
                chToChFreqs[idx][colors[idx] - 'a'] = 1
            }
        }

        var seen = 0
        var largest = 0

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            ++seen

            largest = maxOf(largest, chToChFreqs[cur].maxOrNull()!!)

            graph[cur]?.let {
                for (next in it) {
                    for (i in 0 until 26) {
                        chToChFreqs[next][i] =
                            maxOf(chToChFreqs[next][i], chToChFreqs[cur][i] + if (colors[next] - 'a' == i) 1 else 0)
                    }

                    if (--indegrees[next] == 0)
                        queue.offer(next)
                }
            }
        }

        return if (seen == lenC) largest else -1
    }

    fun buildGraph(nVertices: Int, edges: Array<IntArray>): Pair<Map<Int, HashSet<Int>>, IntArray> {
        val graph = HashMap<Int, HashSet<Int>>()
        val indegrees = IntArray(nVertices) { 0 }

        for ((u, v) in edges) {
            graph.getOrPut(u) { HashSet() }.add(v)
            ++indegrees[v]
        }

        return Pair(graph, indegrees)
    }
}