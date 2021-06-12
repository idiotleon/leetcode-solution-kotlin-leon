/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 *
 * Time Complexity:     O(`nStations` * lg(`nStations`))
 * Space Complexity:    O(`nStations`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy
 */
package com.an7one.leetcode.lvl4.lc0871

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val nStations = stations.size

        val maxHeap = PriorityQueue<Int>(compareBy { -it })

        var furthest = startFuel
        var idx = 0
        var refuel = 0

        while (furthest < target) {
            while (idx < nStations && furthest >= stations[idx][0]) {
                maxHeap.offer(stations[idx][1])
                ++idx
            }

            if (maxHeap.isEmpty()) return -1

            furthest += maxHeap.poll()
            ++refuel
        }

        return refuel
    }
}