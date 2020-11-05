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

class SolutionApproach0Greedy {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val nCars = position.size
        val cars = Array(nCars) { idx -> Car(position[idx], (target - position[idx]).toDouble() / speed[idx]) }

        cars.sortBy { it.position }

        var cur = 0.0
        var fleet = 0
        for (idx in cars.indices.reversed()) {
            val car = cars[idx]
            if (car.time > cur) {
                cur = car.time
                ++fleet
            }
        }

        return fleet
    }

    private data class Car(val position: Int, val time: Double)
}