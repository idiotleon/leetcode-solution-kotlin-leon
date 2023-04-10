package com.idiotleon.leetcode.lvl4.lc1066

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/campus-bikes-ii/
 *
 * Time Complexity:     O(V + E * lg(V))
 * Space Complexity:    O(E * lg(V))
 *
 * Reference:
 * https://leetcode.com/problems/campus-bikes-ii/discuss/303422/Python-Priority-Queue/285136
 * https://leetcode.com/problems/campus-bikes-ii/discuss/303422/Python-Priority-Queue
 */
@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        val nWorkers = workers.size
        val nBikes = bikes.size

        val minHeap = PriorityQueue<Node>(compareBy { it.distance })
        minHeap.offer(Node(0, 0, 0))

        val seen = hashSetOf<String>()

        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val idxWorker = cur.idxWorker
            val state = cur.state
            val distance = cur.distance

            val hash = "$idxWorker#$state"
            if (!seen.add(hash)) continue

            if (idxWorker == nWorkers) return distance

            for (idxBike in 0 until nBikes) {
                if ((state and (1 shl idxBike)) == 0) {
                    minHeap.offer(
                        Node(
                            idxWorker + 1,
                            state or (1 shl idxBike),
                            distance + getDistance(workers[idxWorker], bikes[idxBike])
                        )
                    )
                }
            }
        }

        return -1
    }

    private fun getDistance(worker: IntArray, bike: IntArray): Int {
        return abs(worker[0] - bike[0]) + abs(worker[1] - bike[1])
    }

    private data class Node(val idxWorker: Int, val state: Int, val distance: Int)
}