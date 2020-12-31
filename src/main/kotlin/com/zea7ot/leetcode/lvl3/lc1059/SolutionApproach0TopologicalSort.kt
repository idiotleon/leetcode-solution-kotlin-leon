/**
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
 *
 * Time Complexity:     O(`n` + nEdges)
 * Space Complexity:    O(`n` + nEdges)
 *
 * References:
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/discuss/335148/enough-dfs-there-is-a-plain-simple-bfs-solution/804177
 */
package com.zea7ot.leetcode.lvl3.lc1059

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    fun leadsToDestination(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val graph = List(n) { HashSet<Int>() }
        val indegrees = IntArray(n) { 0 }

        for ((from, to) in edges) {
            ++indegrees[to]
            graph[from].add(to)
        }

        val queue = LinkedList<Int>().also {
            it.offer(source)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                // self loop
                if (graph[cur].contains(cur)) return false

                // if this is an end on the graph
                if (graph[cur].isEmpty() && cur != destination) return false

                for (next in graph[cur]) {
                    // if this is an end on the graph
                    if (indegrees[next] == 0 && next != destination) return false

                    --indegrees[next]
                    queue.offer(next)
                }
            }
        }

        return true
    }
}