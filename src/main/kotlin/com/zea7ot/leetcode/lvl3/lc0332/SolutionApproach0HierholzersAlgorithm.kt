/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 *
 * Time Complexity:     O(`totalTickets` * lg(`totalTickets`)) + O(`totalTickets`) ~ O(`totalTickets` * lg(`totalTickets`))
 *  O(`totalTickets` * lg(`totalTickets`)), consumed by PQ
 *  O(`totalTickets`), consumed by `postorder()`
 *
 * Space Complexity:    O(`totalTickets`) + O(H)
 *
 * to sort the children and post order traverse the graph
 *
 * References:
 *  https://www.youtube.com/watch?v=4udFSOWQpdg
 *  http://zxi.mytechroad.com/blog/graph/leetcode-332-reconstruct-itinerary/
 *  Hierholzer's algorithm: https://en.wikipedia.org/wiki/Eulerian_path
 */
package com.zea7ot.leetcode.lvl3.lc0332

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
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
        // val totalTickets = tickets.size

        val graph = HashMap<String, PriorityQueue<String>>()
        for (ticket in tickets) {
            val (from, to) = ticket
            graph.getOrPut(from) { PriorityQueue() }.add(to)
        }

        val ans = ArrayList<String>()
        postorder(START, graph, ans)
        ans.reverse()
        return ans
    }

    private fun postorder(start: String, graph: Map<String, PriorityQueue<String>>, res: ArrayList<String>) {
        graph[start]?.let { destPQ ->
            while (destPQ.isNotEmpty()) {
                val next = destPQ.poll()
                postorder(next, graph, res)
            }
        }

        res.add(start)
    }
}