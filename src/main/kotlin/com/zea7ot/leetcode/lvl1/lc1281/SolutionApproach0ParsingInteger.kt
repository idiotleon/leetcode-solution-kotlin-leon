/**
 * @author: Leon
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * Time Complexity:     O(digits(`n`))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc1281

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingInteger {
    fun subtractProductAndSum(n: Int): Int {
        var product: Long = 1
        var sum = 0

        var num = n
        while (num > 0) {
            val digit = num % 10
            num /= 10

            product *= digit
            sum += digit
        }

        return (product - sum.toLong()).toInt()
    }
}