/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0121

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen1 {
    fun maxProfit(prices: IntArray): Int {
        // sanity check
        if (prices.isEmpty()) return 0

        var minPrice: Int = Int.MAX_VALUE
        var maxProfit: Int = 0

        for (price in prices) {
            minPrice = minOf(minPrice, price)

            maxProfit = maxOf(maxProfit, price - minPrice)
        }

        return maxProfit
    }
}