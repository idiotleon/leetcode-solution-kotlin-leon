/**
 * https://leetcode.com/problems/paint-house/
 *
 * Time Complexity:     O(`nCosts`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/paint-house/discuss/68211/Simple-java-DP-solution/146145
 */
package com.zea7ot.leetcode.lvl3.lc0256

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minCost(costs: Array<IntArray>): Int {
        // sanity check, required
        if (costs.isEmpty()) return 0

        val nHouses = costs.size

        for (idx in 1 until nHouses) {
            for (color in 0 until 3) {
                costs[idx][color] += minOf(costs[idx - 1][(color + 1) % 3], costs[idx - 1][(color + 2) % 3])
            }
        }

        return minOf(costs.last()[0], costs.last()[1], costs.last()[2])
    }
}