/**
 * https://leetcode.com/problems/paint-house/
 *
 * Time Complexity:     O(`nCosts`)
 * Space Complexity:    O(1)
 *
 * `dp[i][j]`, the minimum cost of painting houses from [0, i] if one paints the i-th house with color j
 *
 * References:
 *  https://leetcode.com/problems/paint-house/discuss/68211/Simple-java-DP-solution
 */
package com.zea7ot.leetcode.lvl3.lc0256

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun minCost(costs: Array<IntArray>): Int {
        // sanity check, required
        if (costs.isEmpty()) return 0

        val nHouses = costs.size

        for (idx in 1 until nHouses) {
            costs[idx][0] += minOf(costs[idx - 1][1], costs[idx - 1][2])
            costs[idx][1] += minOf(costs[idx - 1][0], costs[idx - 1][2])
            costs[idx][2] += minOf(costs[idx - 1][0], costs[idx - 1][1])
        }

        return minOf(costs.last()[0], costs.last()[1], costs.last()[2])
    }
}