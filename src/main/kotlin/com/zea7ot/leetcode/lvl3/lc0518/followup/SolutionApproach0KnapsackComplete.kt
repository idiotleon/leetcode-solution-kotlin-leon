/**
 * @author: Leon
 *
 * Time Complexity:     O(`nCoins` * `target`)
 * Space Complexity:    O(`nCoins` * `target`)
 */
package com.zea7ot.leetcode.lvl3.lc0518.followup

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0KnapsackComplete {
    fun coinChange(coins: IntArray, target: Int): Int {
        val dp = IntArray(target + 1) { 1 + target }.also {
            it[0] = 0
        }

        for (coin in coins) {
            for (faceValue in coin until 1 + target) {
                dp[faceValue] = minOf(dp[faceValue], 1 + dp[faceValue - coin])
            }
        }

        dp[target].let {
            return if (it == 1 + target) -1 else it
        }
    }
}