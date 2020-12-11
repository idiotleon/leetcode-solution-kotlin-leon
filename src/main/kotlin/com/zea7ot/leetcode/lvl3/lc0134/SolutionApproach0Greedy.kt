/**
 * https://leetcode.com/problems/gas-station/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0134

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun canCompleteCircuit(gas: IntArray, costs: IntArray): Int {

        val totalStops = gas.size

        var curTank = 0
        var totalTank = 0
        var startPos = 0

        for (i in 0 until totalStops) {
            val gasBalance = gas[i] - costs[i]
            curTank += gasBalance

            if (curTank < 0) {
                startPos = i + 1
                curTank = 0
            }

            totalTank += gasBalance
        }

        return if (totalTank >= 0) startPos else -1;
    }
}