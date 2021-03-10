/**
 * https://leetcode.com/problems/coin-change-2/
 *
 * Time Complexity:     O(`totalCoins` * `amount`)
 * Space Complexity:    O(`totalCoins` * `amount`)
 *
 * References:
 *  https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
 */
package com.an7one.leetcode.lvl3.lc0518

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun change(amount: Int, coins: IntArray): Int {
        val totalCoins = coins.size
        val dp = Array(totalCoins + 1) { IntArray(amount + 1) { 0 } }
        dp[0][0] = 1

        for (coin in 1..totalCoins) {
            dp[coin][0] = 1
            for (faceValue in 1..amount) {
                dp[coin][faceValue] = if (faceValue >= coins[coin - 1]) {
                    dp[coin - 1][faceValue] + dp[coin][faceValue - coins[coin - 1]]
                } else {
                    dp[coin - 1][faceValue]
                }
            }
        }

        return dp[totalCoins][amount]
    }
}