/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://www.youtube.com/watch?v=CBvPujbmWhU
 */
package com.idiotleon.leetcode.lvl3.lc0714

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0DImen1 {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        // sanity check
        if (prices.isEmpty()) return 0

        var hold = Int.MIN_VALUE
        var sold = 0

        for (price in prices) {
            hold = maxOf(hold, sold - price)
            sold = maxOf(sold, hold + price - fee)
        }

        return sold
    }
}