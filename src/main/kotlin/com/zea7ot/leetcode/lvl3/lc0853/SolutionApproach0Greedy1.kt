/**
 * https://leetcode.com/problems/car-fleet/
 *
 * Time Complexity:     O(`nCars` * lg(`nCars`))
 * Space Complexity:    O(`nCars`)
 *
 * References:
 *  https://leetcode.com/problems/car-fleet/discuss/139850/C%2B%2BJavaPython-Straight-Forward
 */
package com.zea7ot.leetcode.lvl3.lc0853

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

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

        var cur = 0.0
        for ((_, time) in map) {
            if (time > cur) {
                cur = time
                ++fleet
            }
        }

        return fleet
    }
}