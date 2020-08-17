/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0121

class SolutionApproach0DP1 {
    fun maxProfit(prices: IntArray): Int {
        var minPrice: Int = Int.MAX_VALUE
        var maxProfit: Int = 0

        for(price in prices){
            minPrice = minOf(minPrice, price)

            maxProfit = maxOf(maxProfit, price - minPrice)
        }

        return maxProfit
    }
}