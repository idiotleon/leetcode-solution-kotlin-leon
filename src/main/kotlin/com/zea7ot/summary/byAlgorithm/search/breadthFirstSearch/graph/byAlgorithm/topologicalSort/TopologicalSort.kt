/**
 * @author: Leon
 *
 */
package com.zea7ot.summary.byAlgorithm.search.breadthFirstSearch.graph.byAlgorithm.topologicalSort

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class TopologicalSort {
    fun topologicalSort(nVertices: Int, directedGraph: List<List<Int>>): List<Int> {
        // to get the indegrees
        val indegrees = IntArray(nVertices) { 0 }
        for (vertices in directedGraph) {
            for (vertex in vertices) {
                ++indegrees[vertex]
            }
        }

        // to initialize the `queue`
        val queue = LinkedList<Int>().also {
            for (idx in indegrees.indices) {
                if (indegrees[idx] == 0) {
                    it.offer(idx)
                }
            }
        }

        // to topological sort, and build up the answer list
        val ans = mutableListOf<Int>()
        var cntVertices = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                ++cntVertices

                if (--indegrees[cur] == 0) {
                    queue.offer(cur)
                }
            }
        }

        // at least one cycle exists
        if (cntVertices < nVertices) return listOf()
        return ans
    }
}