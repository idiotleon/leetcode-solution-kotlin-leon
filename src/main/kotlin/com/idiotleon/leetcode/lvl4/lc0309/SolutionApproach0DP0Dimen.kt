package com.idiotleon.leetcode.lvl4.lc0309

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://youtu.be/jNy8yM0NBdw
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maxProfit(prices: IntArray): Int {
        // sanity check
        if (prices.isEmpty()) return 0

        var sold = 0
        var held = -prices[0]
        var cooledDown = 0

        for (price in prices) {
            val prevSold = sold
            val prevHeld = held
            val prevCooledDown = cooledDown

            sold = prevHeld + price
            held = maxOf(held, prevCooledDown - price)
            cooledDown = maxOf(prevCooledDown, prevSold)
        }

        return maxOf(sold, cooledDown)
    }
}