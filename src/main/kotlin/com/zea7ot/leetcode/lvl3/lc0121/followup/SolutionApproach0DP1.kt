/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0121.followup

class SolutionApproach0DP1 {
    fun maxProfit(prices: IntArray): Int {
        // sanity check
        if (prices.isEmpty()) return 0

        var maxPrice = Int.MIN_VALUE
        var maxProfit = 0

        for (price in prices) {
            maxPrice = maxOf(maxPrice, price)

            maxProfit = maxOf(maxProfit, maxPrice - price)
        }

        return maxProfit
    }
}