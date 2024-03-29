package com.idiotleon.leetcode.lvl2.lc0121

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maxProfit(prices: IntArray): Int {
        // sanity check
        if (prices.isEmpty()) return 0

        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for (price in prices) {
            if (price < minPrice)
                minPrice = price

            val profit = price - minPrice
            if (profit > maxProfit)
                maxProfit = profit
        }

        return maxProfit
    }
}