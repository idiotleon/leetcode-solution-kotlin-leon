/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * how about sell short this time?
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0121.followup

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP {
    fun maxProfit(prices: IntArray): Int {
        // sanity check
        if (prices.isEmpty()) return 0

        var maxPrice = Int.MIN_VALUE
        var maxProfit = 0

        for (price in prices) {
            if (price > maxPrice)
                maxPrice = price

            val profit = maxPrice - price
            if (profit > maxProfit)
                maxProfit = profit
        }

        return maxProfit
    }
}