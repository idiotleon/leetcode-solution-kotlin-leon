/**
 * https://leetcode.com/problems/paint-house-ii/
 *
 * Time Complexity:     O(`nHouses` * (`kColors` ^ 2))
 * Space Complexity:    O(`nHouses` * `kColors`)
 *
 * `dp[i][j]` = min{ dp[i - 1][j'] + costs[i][j]}
 *      j' = 1, 2, 3, ..., (j - 1), (j + 1), ..., `kColors` (but not `j`)
 *
 *  a bottom-up approach
 *
 * References:
 *  https://leetcode.com/problems/paint-house-ii/discuss/69492/AC-Java-solution-without-extra-space/71565
 *  https://youtu.be/FLbqgyJ-70I?t=1433
 */
package com.an7one.leetcode.lvl4.lc0265

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1DP2Dimen {
    fun minCostII(costs: Array<IntArray>): Int {
        // sanity check
        if (costs.isEmpty() || costs[0].isEmpty()) return 0

        val nHouses = costs.size
        val nColors = costs[0].size

        val dp = Array(nHouses) { IntArray(nColors) { 0 } }
        for (idxColor in 0 until nColors) {
            dp[0][idxColor] = costs[0][idxColor]
        }

        for (idxHouse in 1 until nHouses) {
            for (idxPrevColor in costs[idxHouse].indices) {
                dp[idxHouse][idxPrevColor] = Int.MAX_VALUE
                for (idxCurColor in costs[idxHouse].indices) {
                    if (idxCurColor == idxPrevColor) continue

                    dp[idxHouse][idxPrevColor] =
                        minOf(dp[idxHouse][idxPrevColor], dp[idxHouse - 1][idxCurColor] + costs[idxHouse][idxPrevColor])
                }
            }
        }

        var minCost = Int.MAX_VALUE
        for (idxColor in dp.last().indices) {
            minCost = minOf(minCost, dp.last()[idxColor])
        }
        return minCost
    }
}