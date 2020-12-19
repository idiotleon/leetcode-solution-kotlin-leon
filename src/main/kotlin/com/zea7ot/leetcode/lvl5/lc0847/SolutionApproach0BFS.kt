/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 *
 * Time Complexity:     O(N * (2 ^ N))
 * Space Complexity:    O(N * (2 ^ N))
 *
 * References:
 *  https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135809/Fast-BFS-Solution-(46ms)-Clear-Detailed-Explanation-Included/237938
 *  https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135809/Fast-BFS-Solution-(46ms)-Clear-Detailed-Explanation-Included
 */
package com.zea7ot.leetcode.lvl5.lc0847

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val totalVertices = graph.size
        val fullMask = (1 shl totalVertices) - 1

        val seen = HashSet<String>()
        val queue = LinkedList<State>()
        for (vertex in graph.indices) {
            val node = State(vertex, 1 shl vertex)
            queue.offer(node)
            seen.add(node.toHash())
        }

        var steps = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val cur = queue.poll()
                val vertex = cur.vertex
                val bitMask = cur.bitMask
                if (bitMask == fullMask) return steps
                for (nextVertex in graph[vertex]) {
                    val nextNode = State(nextVertex, bitMask or (1 shl nextVertex))
                    if (!seen.add(nextNode.toHash())) continue
                    queue.offer(nextNode)
                }
            }

            ++steps
        }

        return -1
    }

    private data class State(val vertex: Int, val bitMask: Int) {
        fun toHash() = "$vertex#$bitMask"
    }
}