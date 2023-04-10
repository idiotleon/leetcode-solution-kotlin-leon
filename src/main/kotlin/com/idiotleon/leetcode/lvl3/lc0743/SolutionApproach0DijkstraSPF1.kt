package com.idiotleon.leetcode.lvl3.lc0743

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/network-delay-time/
 *
 * Time Complexity:     O(E * lg(V)) ~ O(`nTimes` * lg(`nNodes`))
 * Space Complexity:    O()
 *
 * Dijkstra's SPF optimized with a min heap is comparably suitable for sparse graphs
 *
 * Reference:
 * https://leetcode-cn.com/problems/network-delay-time/solution/dan-yuan-zui-duan-lu-po-su-de-dijkstra-dui-you-hua/
 */
@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF1 {
    private companion object {
        private const val DATA_RANGE = 100 + 1
    }

    fun networkDelayTime(times: Array<IntArray>, nNodes: Int, start: Int): Int {
        val graph = buildGraph(times, nNodes)

        val minHeap = PriorityQueue<Edge>(compareBy { it.time }).also {
            it.offer(Edge(-1, start - 1, 0))
        }

        val visited = BooleanArray(nNodes) { false }
        var steps = 0

        while (minHeap.isNotEmpty()) {
            val (_, curEndNode, curTime) = minHeap.poll()

            if (visited[curEndNode]) continue
            visited[curEndNode] = true

            for ((_, nextEndNode, nextTime) in graph[curEndNode]) {
                minHeap.offer(Edge(curEndNode, nextEndNode, nextTime + curTime))
            }

            if (++steps == nNodes) return curTime
        }

        return -1
    }

    private fun buildGraph(times: Array<IntArray>, nNodes: Int): List<List<Edge>> {
        val graph = List(nNodes) { mutableListOf<Edge>() }

        for ((start, end, time) in times) {
            graph[start - 1].add(Edge(start - 1, end - 1, time))
        }

        return graph
    }

    /**
     * `startNode` is not necessary. Here is just to keep easiness and completeness
     */
    private data class Edge(val startNode: Int, val nextNode: Int, val time: Int)

    // this is more concise, but slightly harder to understand
    // private data class State(val nodeID: Int, val time: Int)
}