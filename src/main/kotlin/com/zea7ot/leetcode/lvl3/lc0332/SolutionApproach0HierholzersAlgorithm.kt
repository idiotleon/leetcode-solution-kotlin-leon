/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 *
 * Time Complexity:     O(`nTickets` * lg(`nTickets`)) + O(`nTickets`) ~ O(`nTickets` * lg(`nTickets`))
 *  O(`nTickets` * lg(`nTickets`)), consumed by Priority Queue
 *  O(`nTickets`), consumed by `postorder()`
 *
 * Space Complexity:    O(`nTickets`) + O(H)
 *
 * to sort the children and post order traverse the graph
 *
 * References:
 *  https://www.youtube.com/watch?v=4udFSOWQpdg
 *  http://zxi.mytechroad.com/blog/graph/leetcode-332-reconstruct-itinerary/
 *  Hierholzer's algorithm: https://en.wikipedia.org/wiki/Eulerian_path
 */
package com.zea7ot.leetcode.lvl3.lc0332

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0HierholzersAlgorithm {
    private companion object {
        private const val START = "JFK"
    }

    fun findItinerary(tickets: List<List<String>>): List<String> {
        // not used
        // val nTickets = tickets.size

        // to build the graph
        val graph = HashMap<String, PriorityQueue<String>>()
        for ((from, to) in tickets) {
            graph.getOrPut(from) { PriorityQueue() }.add(to)
        }

        // to postorder traverse
        val path = ArrayList<String>()
        postorder(START, graph, path)
        path.reverse()

        return path
    }

    private fun postorder(
        start: String,
        graph: Map<String, PriorityQueue<String>>,
        path: ArrayList<String>
    ) {
        graph[start]?.let { destPQ ->
            while (destPQ.isNotEmpty()) {
                val next = destPQ.poll()
                postorder(next, graph, path)
            }
        }

        path.add(start)
    }
}