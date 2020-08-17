/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://www.youtube.com/watch?v=gsL3T9bI1RQ
 */
package com.zea7ot.lc.lvl5.lc0123

class SolutionApproach0DP {
    fun maxProfit(prices: IntArray): Int {
        // sanity check
        if (prices.isEmpty()) return 0

        var held1 = -prices[0]
        var held2 = -prices[0]
        var sold1 = 0
        var sold2 = 0

        for (price in prices) {
            val prevHeld1 = held1
            val prevHeld2 = held2
            val prevSold1 = sold1
            val prevSold2 = sold2

            held1 = maxOf(prevHeld1, -price)
            sold1 = maxOf(prevSold1, prevHeld1 - price)
            held2 = maxOf(prevHeld2, prevSold1 - price)
            sold2 = maxOf(prevSold2, prevHeld2 + price)
        }

        return sold2
    }
}