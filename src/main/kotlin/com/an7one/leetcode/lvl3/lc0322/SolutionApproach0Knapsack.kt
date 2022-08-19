package com.an7one.leetcode.lvl3.lc0322

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/coin-change/
 *
 * Time Complexity:     O(`nCoins` * `amount`)
 * Space Complexity:    O(`amount`)
 *
 * Reference:
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
 */
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