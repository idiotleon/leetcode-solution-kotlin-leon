package com.idiotleon.leetcode.lvl2.lc2160

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0ParsingInteger {
    fun minimumSum(num: Int): Int {
        // sorted
        val allDigits = getAllDigits(num)

        val num1 = allDigits[0] * 10 + allDigits[2]
        val num2 = allDigits[1] * 10 + allDigits[3]

        return num1 + num2
    }

    // sorted
    private fun getAllDigits(num: Int): List<Int> {
        val res = MutableList<Int>(4) { 0 }.also {
            var num = num
            var idx = 0
            while (num > 0) {
                val digit = num % 10
                it[idx] = digit
                num /= 10
                ++idx
            }
            it.sort()
        }
        return res
    }
}