package com.idiotleon.leetcode.lvl2.lc1475

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * Time Complexity:     O(`nPrices`)
 * Space Complexity:    O(`nPrices`)
 */
@Suppress(UNUSED)
class Solution0MonoStack {
    fun finalPrices(prices: IntArray): IntArray {
        val nPrices = prices.size
        val stack = ArrayDeque<Int>(nPrices)
        val ans = IntArray(nPrices) { 0 }
        for ((idx, price) in prices.withIndex()) {
            while (stack.isNotEmpty() && price <= prices[stack.last()]) {
                val topIdx = stack.removeLast()
                ans[topIdx] = prices[topIdx] - price
            }

            stack.addLast(idx)
        }

        while (stack.isNotEmpty()) {
            val topIdx = stack.removeLast()
            ans[topIdx] = prices[topIdx]
        }

        return ans
    }
}