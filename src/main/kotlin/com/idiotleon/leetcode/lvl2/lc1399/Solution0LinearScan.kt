package com.idiotleon.leetcode.lvl2.lc1399

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/***
 * @author: Leon
 * https://leetcode.com/problems/count-largest-group/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun countLargestGroup(n: Int): Int {
        val digitSumToNums = HashMap<Int, MutableList<Int>>(n).also {
            for (num in 1..n) {
                val digitSum = getDigitSum(num)
                it.getOrPut(digitSum) { mutableListOf() }.add(num)
            }
        }

        val values = digitSumToNums.values

        val sizeOfMost = values.maxBy { it.size }.size

        return digitSumToNums.values.count { it.size == sizeOfMost }
    }

    private fun getDigitSum(num: Int): Int {
        var num = num
        var sum = 0
        while (num > 0) {
            val digit = num % 10
            sum += digit
            num /= 10
        }
        return sum
    }
}