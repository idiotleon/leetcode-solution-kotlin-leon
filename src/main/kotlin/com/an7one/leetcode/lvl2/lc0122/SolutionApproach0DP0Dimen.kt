/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl2.lc0122

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maxProfit(prices: IntArray): Int {
        val nPrices = prices.size
        var maxProfit = 0

        for (idx in 1 until nPrices) {
            if (prices[idx - 1] < prices[idx]) {
                maxProfit += prices[idx] - prices[idx - 1]
            }
        }

        return maxProfit
    }
}