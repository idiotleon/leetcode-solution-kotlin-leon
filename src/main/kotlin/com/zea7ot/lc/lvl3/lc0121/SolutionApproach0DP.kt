/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0121

class SolutionApproach0DP {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for(price in prices){
            if(price < minPrice)
                minPrice = price;

            val profit = price - minPrice
            if(profit > maxProfit)
                maxProfit = profit
        }

        return maxProfit
    }
}