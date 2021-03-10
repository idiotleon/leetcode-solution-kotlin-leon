/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0714

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        // sanity check
        if (prices.isEmpty()) return 0

        var held = -prices[0]
        var sold = 0

        for (price in prices) {
            val prevHold = held
            val prevSold = sold
            held = maxOf(prevHold, prevSold + price)
            sold = maxOf(prevSold, prevHold + price - fee)
        }

        return sold
    }
}