package com.idiotleon.leetcode.lvl2.lc2342

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class Solution0BucketSort {
    fun maximumSum(nums: IntArray): Int {
        val nNums = nums.size

        var max = -1
        val sumToNums = MutableList(81 + 1) { 0 }
        for (num in nums) {
            val digitSum = getSum(num)
            val existing = sumToNums[digitSum]
            if (existing > 0) {
                max = maxOf(max, existing + num)
            }

            sumToNums[digitSum] = maxOf(existing, num)
        }

        return max
    }

    private fun getSum(num: Int): Int {
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