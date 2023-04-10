package com.idiotleon.leetcode.lvl3.lc0853

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/car-fleet/
 *
 * Time Complexity:     O(`nCars` * lg(`nCars`))
 * Space Complexity:    O(`nCars`)
 *
 * Reference:
 * https://leetcode.com/problems/car-fleet/discuss/139850/C%2B%2BJavaPython-Straight-Forward
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        // not used
        // val nCars = position.size

        val map = TreeMap<Int, Double>(compareByDescending { it })
        for (idx in position.indices) {
            map[position[idx]] = (target - position[idx]).toDouble() / speed[idx]
        }

        var fleet = 0

        var curTimeLimit = 0.0
        for ((_, time) in map) {
            if (time > curTimeLimit) {
                curTimeLimit = time
                ++fleet
            }
        }

        return fleet
    }
}