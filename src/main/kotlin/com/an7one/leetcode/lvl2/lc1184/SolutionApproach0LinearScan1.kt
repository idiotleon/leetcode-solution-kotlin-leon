/**
 * https://leetcode.com/problems/distance-between-bus-stops/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/distance-between-bus-stops/discuss/377444/Java-O(n)-solution-Easy-to-understand
 */
package com.an7one.leetcode.lvl2.lc1184

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun distanceBetweenBusStops(distances: IntArray, start: Int, destination: Int): Int {
        // not used
        // val nNodes = distances.size

        var lo = start
        var hi = destination
        if (lo > hi) {
            val temp = lo
            lo = hi
            hi = temp
        }

        var res = 0
        var total = 0

        for (idx in distances.indices) {
            if (idx in lo until hi) {
                res += distances[idx]
            }

            total += distances[idx]
        }

        return minOf(res, total - res)
    }
}