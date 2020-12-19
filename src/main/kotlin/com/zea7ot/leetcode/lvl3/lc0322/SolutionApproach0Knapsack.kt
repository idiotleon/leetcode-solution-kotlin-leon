/**
 * https://leetcode.com/problems/coin-change/
 *
 * Time Complexity:     O(`nCoins` * `amount`)
 * Space Complexity:    O(`amount`)
 *
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
 */
package com.zea7ot.leetcode.lvl3.lc0322

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Knapsack {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // not used
        // val nCoins = coins.size

        val dp = IntArray(amount + 1) { idx -> if (idx == 0) 0 else amount + 1 }

        for (coin in coins) {
            for (faceValue in coin..amount) {
                dp[faceValue] = minOf(dp[faceValue], 1 + dp[faceValue - coin])
            }
        }

        return if (dp[amount] >= amount + 1) -1 else dp[amount]
    }
}