package com.idiotleon.leetcode.lvl2.lc0122

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Time Complexity:     O(`nPrices`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maxProfit(prices: IntArray): Int {
        val nPrices = prices.size
        var maxProfit = 0

        for (idx in 1 until nPrices) {
            if (prices[idx - 1] < prices[idx])
                maxProfit += prices[idx] - prices[idx - 1]
        }

        return maxProfit
    }
}