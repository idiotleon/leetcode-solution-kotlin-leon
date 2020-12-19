/**
 * https://leetcode.com/problems/stone-game-v/
 *
 * Time Complexity:     O(`nStones` ^ 3)
 * Space Complexity:    O(`nStones` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/stone-game-v/discuss/806761/Python-DP/676538
 *  https://leetcode.com/problems/stone-game-v/discuss/806761/Python-DP
 */
package com.zea7ot.leetcode.lvl4.lc1563

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun stoneGameV(stoneValues: IntArray): Int {
        val nStones = stoneValues.size
        val prefixSums = IntArray(nStones + 1) { 0 }
        for (idx in stoneValues.indices) {
            prefixSums[idx + 1] = prefixSums[idx] + stoneValues[idx]
        }

        val dp = Array(nStones + 1) { IntArray(nStones + 1) { 0 } }

        for (len in 2..nStones) {
            for (lo in 0..nStones - len) {
                val hi = lo + len

                for (k in lo + 1 until hi) {
                    val leftSum = prefixSums[k] - prefixSums[lo]
                    val rightSum = prefixSums[hi] - prefixSums[k]

                    if (leftSum <= rightSum) {
                        dp[lo][hi] = maxOf(dp[lo][hi], leftSum + dp[lo][k])
                    }

                    if (leftSum >= rightSum) {
                        dp[lo][hi] = maxOf(dp[lo][hi], rightSum + dp[k][hi])
                    }
                }
            }
        }

        return dp[0][nStones]
    }
}