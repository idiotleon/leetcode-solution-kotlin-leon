package com.an7one.leetcode.lvl4.lc0188

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * Time Complexity:     O(`K` * `nDays`)
 * Space Complexity:    O(`K` * `nDays`)
 *
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxProfit(K: Int, prices: IntArray): Int {
        val nDays = prices.size

        if (K >= nDays) {
            var maxProfit = 0
            for (day in 1 until nDays) {
                if (prices[day - 1] < prices[day]) {
                    maxProfit += prices[day] - prices[day - 1]
                }
            }

            return maxProfit
        }

        val dp = Array(K + 1) { IntArray(nDays) { 0 } }
        for (k in 1..K) {
            var localMax = dp[k - 1][0] - prices[0];

            for (day in 1 until nDays) {
                dp[k][day] = maxOf(dp[k][day - 1], prices[day] + localMax)
                localMax = maxOf(localMax, dp[k - 1][day] - prices[day])
            }
        }

        return dp[K][nDays - 1]
    }
}