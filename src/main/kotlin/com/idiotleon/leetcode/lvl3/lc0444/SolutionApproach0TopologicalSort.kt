package com.idiotleon.leetcode.lvl3.lc0444

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

/**
 * @author: Leon
 * https://leetcode.com/problems/sequence-reconstruction/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * to return true, it must be that:
 *  1. the topological sort order exists
 *  2. the topological sort order is unique
 *  3. the topological sort order confirms to `org`
 *
 * Reference:
 * https://leetcode.com/problems/sequence-reconstruction/discuss/92580/Java-Solution-using-BFS-Topological-Sort/143050
 * https://leetcode.com/problems/sequence-reconstruction/discuss/92580/Java-Solution-using-BFS-Topological-Sort/97078
 * https://leetcode.com/problems/sequence-reconstruction/discuss/92580/Java-Solution-using-BFS-Topological-Sort
 */
@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    fun sequenceReconstruction(org: IntArray, seqs: List<List<Int>>): Boolean {
        val nOrg = org.size

        val counts = HashMap<Int, Int>()
        val graph = buildGraph(seqs, counts)
        if (nOrg != counts.size) {
            return false
        }

        // to topological sort
        val queue = ArrayDeque<Int>().also {
            for ((num, count) in counts) {
                if (count == 0) {
                    it.addLast(num)
                }
            }
        }

        var idx = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            // the topological sort order should be unique
            if (size > 1) {
                return false
            }

            val cur = queue.removeFirst()
            // the topological sort order should confirm to `org`
            if (org[idx++] != cur) {
                return false
            }

            graph[cur]?.let {
                for (next in it) {
                    counts[next] = (counts[next] ?: 0) - 1
                    if (counts[next] == 0) {
                        queue.addLast(next)
                    }
                }
            }
        }

        return idx == nOrg
    }

    private fun buildGraph(
        seqs: List<List<Int>>,
        counts: HashMap<Int, Int>,
    ): Map<Int, List<Int>> {
        val graph = HashMap<Int, MutableList<Int>>()
        for (seq in seqs) {
            for (idx in seq.indices) {
                graph.getOrPut(seq[idx]) { mutableListOf() }
                counts.getOrPut(seq[idx]) { 0 }

                if (idx > 0) {
                    graph.getOrPut(seq[idx - 1]) { mutableListOf() }.add(seq[idx])
                    counts[seq[idx]] = 1 + (counts[seq[idx]] ?: 0)
                }
            }
        }

        return graph.map { (key, value) -> key to value.toList() }.toMap()
    }
}