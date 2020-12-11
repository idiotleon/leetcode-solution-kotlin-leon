/**
 * https://leetcode.com/problems/sequence-reconstruction/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * to return true, it must:
 *  1. the topological sort order exists
 *  2. the topological sort order is unique
 *  3. the topological sort order confirms to `org`
 *
 * References:
 *  https://leetcode.com/problems/sequence-reconstruction/discuss/92580/Java-Solution-using-BFS-Topological-Sort/143050
 *  https://leetcode.com/problems/sequence-reconstruction/discuss/92580/Java-Solution-using-BFS-Topological-Sort/97078
 *  https://leetcode.com/problems/sequence-reconstruction/discuss/92580/Java-Solution-using-BFS-Topological-Sort
 */
package com.zea7ot.leetcode.lvl3.lc0444

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    fun sequenceReconstruction(org: IntArray, seqs: List<List<Int>>): Boolean {
        val nOrg = org.size

        val indegrees = HashMap<Int, Int>()
        val graph = buildGraph(seqs, indegrees)
        if (nOrg != indegrees.size) return false

        // to topological sort
        val queue = LinkedList<Int>()
        for ((num, indegree) in indegrees) {
            if (indegree == 0) {
                queue.offer(num)
            }
        }

        var idx = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            // the topological sort order should be unique
            if (size > 1) return false

            val cur = queue.poll()
            // the topological sort order should confirm to `org`
            if (org[idx++] != cur) return false

            graph[cur]?.let {
                for (next in it) {
                    indegrees[next] = (indegrees[next] ?: 0) - 1
                    if (indegrees[next] == 0) {
                        queue.offer(next)
                    }
                }
            }
        }

        return idx == nOrg
    }

    private fun buildGraph(seqs: List<List<Int>>,
                           indegrees: HashMap<Int, Int>): HashMap<Int, MutableList<Int>> {
        val graph = HashMap<Int, MutableList<Int>>()
        for (seq in seqs) {
            for (idx in seq.indices) {
                graph.getOrPut(seq[idx]) { mutableListOf() }
                indegrees.getOrPut(seq[idx]) { 0 }

                if (idx > 0) {
                    graph.getOrPut(seq[idx - 1]) { mutableListOf() }.add(seq[idx])
                    indegrees[seq[idx]] = 1 + (indegrees[seq[idx]] ?: 0)
                }
            }
        }

        return graph
    }
}