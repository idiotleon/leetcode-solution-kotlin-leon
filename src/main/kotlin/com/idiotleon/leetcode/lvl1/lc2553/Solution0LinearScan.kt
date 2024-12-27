package com.idiotleon.leetcode.lvl1.lc2553

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/separate-the-digits-in-an-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun separateDigits(nums: IntArray): IntArray {
        val nNums = nums.size
        val res = mutableListOf<Int>()
        for (num in nums) {
            getDigits(num, res)
        }
        return res.toIntArray()
    }

    private fun getDigits(num: Int, res: MutableList<Int>) {
        var num = num
        val stack = ArrayDeque<Int>(6)
        while (num > 0) {
            val digit = num % 10
            stack.addLast(digit)
            num /= 10
        }
        while (stack.isNotEmpty()) {
            val top = stack.removeLast()
            res.add(top)
        }
    }
}