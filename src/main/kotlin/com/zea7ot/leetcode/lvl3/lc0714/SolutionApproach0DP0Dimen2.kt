/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0714

class SolutionApproach0DP0Dimen2{
    fun maxProfit(prices: IntArray, fee: Int): Int {
        // sanity check
        if(prices.isEmpty()) return 0

        val n = prices.count()
        var buy = -prices[0]
        var sell = 0
        for(i in 1 until n){
            val tempBuy = buy;
            buy = maxOf(buy, sell - prices[i])
            sell = maxOf(sell, tempBuy + prices[i] - fee)
        }

        return maxOf(buy, sell)
    }
}