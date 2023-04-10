/**
 * https://leetcode.com/problems/distance-between-bus-stops/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/distance-between-bus-stops/discuss/410131/Java-Beats-100-Easy-Solution
 */
package com.idiotleon.leetcode.lvl2.lc1184

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun distanceBetweenBusStops(distances: IntArray, start: Int, destination: Int): Int {
        val nNodes = distances.size

        var clockwise = 0
        var idx = start
        while (idx != destination) {
            clockwise += distances[idx]
            idx = (idx + 1) % nNodes
        }

        var counterClockwise = 0
        idx = destination
        while (idx != start) {
            counterClockwise += distances[idx]
            idx = (idx + 1) % nNodes
        }

        return minOf(clockwise, counterClockwise)
    }
}