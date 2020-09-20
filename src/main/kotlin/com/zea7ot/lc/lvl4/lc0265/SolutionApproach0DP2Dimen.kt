/**
 * https://leetcode.com/problems/paint-house-ii/
 *
 * Time Complexity:     O(`nHouses` * (`kColors` ^ 2))
 * Space Complexity:    O(`nHouses` * `kColors`)
 *
 * `dp[i][j]` = min{ dp[i - 1][j'] + costs[i][j]}
 *      j' = 1, 2, 3, ..., (j - 1), (j + 1), ..., `kColors` (but not `j`)
 *
 * References:
 *  https://leetcode.com/problems/paint-house-ii/discuss/69492/AC-Java-solution-without-extra-space/71565
 *  https://youtu.be/FLbqgyJ-70I?t=1433
 */
package com.zea7ot.lc.lvl4.lc0265

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minCostII(costs: Array<IntArray>): Int {
        // sanity check
        if (costs.isEmpty() || costs[0].isEmpty()) return 0

        val nHouses = costs.size
        val kColors = costs[0].size

        val dp = Array(nHouses) { IntArray(kColors) { 0 } }
        for (k in 0 until kColors) {
            dp[0][k] = costs[0][k]
        }

        for (i in 1 until nHouses) {
            for (j in 0 until kColors) {
                dp[i][j] = Int.MAX_VALUE
                for (k in 0 until kColors) {
                    if (k == j) continue

                    dp[i][j] = minOf(dp[i][j], dp[i - 1][k] + costs[i][j])
                }
            }
        }

        var minCost = Int.MAX_VALUE
        for (k in 0 until kColors) {
            minCost = minOf(minCost, dp[nHouses - 1][k])
        }
        return minCost
    }
}