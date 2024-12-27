package com.idiotleon.leetcode.lvl2.lc0485

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        val nNums = nums.size

        var longest = 0
        var len = 0

        for (num in nums) {
            if (num == 0) {
                len = 0
            } else {
                longest = maxOf(longest, ++len)
            }
        }

        return longest
    }
}