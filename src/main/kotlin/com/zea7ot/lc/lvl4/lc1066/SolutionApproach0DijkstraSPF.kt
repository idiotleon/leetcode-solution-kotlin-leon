/**
 * https://leetcode.com/problems/campus-bikes-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/303422/Python-Priority-Queue/285136
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/303422/Python-Priority-Queue
 */
package com.zea7ot.lc.lvl4.lc1066

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0DijkstraSPF {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        val totalWorkers = workers.size
        val totalBikes = bikes.size

        val minHeap = PriorityQueue<Node> { a, b -> a.distance.compareTo(b.distance) }
        minHeap.offer(Node(0, 0, 0))

        val seen = hashSetOf<String>()

        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val idxWorker = cur.idxWorker
            val state = cur.state
            val distance = cur.distance

            val hash = "$idxWorker#$state"

            if (!seen.add(hash)) continue

            if (idxWorker == totalWorkers) return cur.distance

            for (idxBike in 0 until totalBikes) {
                if ((state and (1 shl idxBike)) == 0) {
                    minHeap.offer(Node(idxWorker + 1, state or (1 shl idxBike),
                            distance + getDistance(workers[idxWorker], bikes[idxBike])))
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