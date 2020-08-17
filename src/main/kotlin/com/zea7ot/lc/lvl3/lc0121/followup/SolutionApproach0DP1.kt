/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0121.followup

class SolutionApproach0DP1 {
    fun maxProfit(prices: IntArray): Int{
        var maxPrice = Int.MIN_VALUE
        var maxProfit = 0

        for(price in prices){
            maxPrice = maxOf(maxPrice, price)

            maxProfit = maxOf(maxProfit, maxPrice - price)
        }

        return maxProfit
    }
}