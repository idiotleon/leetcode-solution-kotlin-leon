package com.idiotleon.leetcode.lvl2.lc2303

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/calculate-amount-paid-in-taxes/
 *
 * Time Complexity:     O(`nBrackets`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
        val nBrackets = brackets.size

        var prevUpper = 0
        var tax: Double = 0.0

        for ((upper, rateValue) in brackets) {
            val rate = rateValue.toDouble() / 100.0
            if (income > upper) {
                tax += (upper - prevUpper).toDouble() * rate
                prevUpper = upper
            } else {
                tax += (income - prevUpper).toDouble() * rate
                break
            }
        }

        return tax
    }
}