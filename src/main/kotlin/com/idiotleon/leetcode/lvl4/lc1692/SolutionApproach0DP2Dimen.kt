package com.idiotleon.leetcode.lvl4.lc1692

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-ways-to-distribute-candies/
 *
 * Time Complexity:     O(`n` * `k`)
 * Space Complexity:    O(`n` * `k`)
 *
 * dp[i][j], to use all the first i candies to put them into j bags
 *
 * Reference:
 * https://leetcode.com/problems/count-ways-to-distribute-candies/discuss/979889/Java-Concise-DP-Solution-with-Explanations
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toLong() + 7
    }

    fun waysToDistribute(n: Int, k: Int): Int {
        val dp = Array(n + 1) { LongArray(k + 1) { 0L } }.also {
            it[0][0] = 1
        }

        for (idxBag in 1..k) {
            for (idxCandy in idxBag..n) {
                // the `idxCandy` candy to be put into a standalone bag
                dp[idxCandy][idxBag] = dp[idxCandy - 1][idxBag - 1]

                // to put the `idxCandy` candy into the previous `idxBag` bags
                if (idxCandy - 1 >= idxBag) dp[idxCandy][idxBag] += dp[idxCandy - 1][idxBag] * idxBag % MOD
                dp[idxCandy][idxBag] %= MOD
            }
        }

        return dp[n][k].toInt()
    }
}