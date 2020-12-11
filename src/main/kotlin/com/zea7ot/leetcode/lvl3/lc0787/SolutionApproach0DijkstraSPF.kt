/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * Time Complexity:     O(V + E * lg(V)) ~  O(`n` + `totalFlights` * lg(`n`))
 * Space Complexity:    O(V) ~ O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/115541/JavaPython-Priority-Queue-Solution
 *  https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's
 */
package com.zea7ot.leetcode.lvl3.lc0787

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.ArrayList

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    fun findCheapestPrice(n: Int,
                          flights: Array<IntArray>,
                          src: Int,
                          dst: Int,
                          K: Int): Int {

        // not used
        // total edges
        // val totalFlights = flights.size

        val graph = buildGraph(n, flights, K)

        val minHeap = PriorityQueue<Vertex>(compareBy { it.price })
        minHeap.offer(Vertex(src, 0, K + 1))

        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()

            val city = cur.city
            val price = cur.price
            if (city == dst) return cur.price

            val stops = cur.stops
            if (stops > 0) {
                for (next in graph[city]) {
                    minHeap.offer(Vertex(next.city, price + next.price, stops - 1))
                }
            }
        }

        return -1
    }

    private fun buildGraph(n: Int, flights: Array<IntArray>, K: Int): Array<ArrayList<Vertex>> {
        val graph = Array(n) { arrayListOf<Vertex>() }

        for (flight in flights) {
            val from = flight[0]
            val to = flight[1]
            val price = flight[2]
            graph[from].add(Vertex(to, price, -1))
        }

        return graph
    }

    private data class Vertex(val city: Int, val price: Int, val stops: Int)
}