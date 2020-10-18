/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * Time Complexity:     O(`K` * `totalDays`)
 * Space Complexity:    O(`K` * `totalDays`)
 *
 * References:
 *  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment
 */
package com.zea7ot.leetcode.lvl4.lc0188

class SolutionApproach0DP2Dimen {
    fun maxProfit(K: Int, prices: IntArray): Int {
        val totalDays = prices.size

        if (K >= totalDays) {
            var maxProfit = 0
            for (day in 1 until totalDays) {
                if (prices[day - 1] < prices[day]) {
                    maxProfit += prices[day] - prices[day - 1]
                }
            }

            return maxProfit
        }

        val dp = Array(K + 1) { IntArray(totalDays) { 0 } }
        for (k in 1..K) {
            var localMax = dp[k - 1][0] - prices[0];

            for (day in 1 until totalDays) {
                dp[k][day] = maxOf(dp[k][day - 1], prices[day] + localMax)
                localMax = maxOf(localMax, dp[k - 1][day] - prices[day])
            }
        }

        return dp[K][totalDays - 1]
    }
}