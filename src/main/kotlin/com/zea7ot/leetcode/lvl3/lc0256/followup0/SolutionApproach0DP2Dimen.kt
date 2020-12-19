/**
 * if there are m colors, instead of 3, how to solve the problem?
 * https://leetcode.com/problems/paint-house/
 *
 * Time Complexity:     O(`nHouses` * (`nColors`) ^ 2)
 * Space Complexity:    O(`nHouses` * `nColors`)
 *
 * References:
 *  https://leetcode.com/problems/paint-house/discuss/68243/Java-solution-Not-limited-to-3-colors-No-change-to-original-input
 */
package com.zea7ot.leetcode.lvl3.lc0256.followup0

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun getMinCost(costs: Array<IntArray>): Int {
        // sanity check, required
        if (costs.isEmpty() || costs[0].isEmpty()) return 0

        val nHouses = costs.size
        val nColors = costs[0].size

        val dp = Array(nHouses) { IntArray(nColors) { 0 } }
        for (idxColor in costs[0].indices) {
            dp[0][idxColor] = costs[0][idxColor]
        }

        for (idxHouse in 1 until nHouses) {
            for (idxColor in costs[idxHouse].indices) {
                dp[idxHouse][idxColor] = costs[idxHouse][idxColor] + getMinCost(idxHouse - 1, idxColor, dp)
            }
        }

        return getMinCost(nHouses - 1, -1, dp)
    }

    private fun getMinCost(idxHouse: Int, idxPrevColor: Int, costs: Array<IntArray>): Int {
        var minCost = Int.MAX_VALUE

        for (idxColor in costs[idxHouse].indices) {
            if (idxColor == idxPrevColor) continue

            minCost = minOf(minCost, costs[idxHouse][idxColor])
        }

        return minCost
    }
}