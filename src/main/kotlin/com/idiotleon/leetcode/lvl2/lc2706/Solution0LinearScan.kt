package com.idiotleon.leetcode.lvl2.lc2706

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/buy-two-chocolates/
 *
 * Time Complexity:     O(`nPrices`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun buyChoco(prices: IntArray, money: Int): Int {
        val nPrices = prices.size
        
        var cheapest: Int? = null
        var secCheapest: Int? = null

        for (price in prices) {
            if (cheapest == null || price < cheapest) {
                secCheapest = cheapest
                cheapest = price
            } else if (secCheapest == null || price < secCheapest) {
                secCheapest = price
            }
        }

        if (cheapest != null && secCheapest != null) {
            val sum = cheapest + secCheapest
            if (sum <= money) {
                return money - sum
            }
        }

        return money
    }
}