/**
 * https://leetcode.com/problems/coin-change-2/
 *
 * Time Complexity:     O(`totalCoins` * `amount`)
 * Space Complexity:    O(`amount`)
 *
 * space can be compressed,
 * since dp[i][j] only depends on dp[i - 1][j] and dp[i][j - coins[i]]
 *
 * References:
 *  https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
 *
 * Almost the same problem:
 *  https://leetcode.com/problems/combination-sum-iv/discuss/111860/Coin-change-AND-this-problem
 */
package com.idiotleon.leetcode.lvl3.lc0518

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Knapsack {
    fun change(amount: Int, coins: IntArray): Int {
        // not used
        // val totalCoins = coins.size

        val dp = IntArray(amount + 1) { idx -> if (idx == 0) 1 else 0 }

        for (coin in coins) {
            for (faceValue in coin..amount) {
                dp[faceValue] += dp[faceValue - coin]
            }
        }

        return dp[amount]
    }
}