package com.idiotleon.leetcode.lvl1.lc3105

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        val nNums = nums.size

        var longest = 1
        var lenInc = 1
        var lenDec = 1
        for (idx in 0 until nNums - 1) {
            if (nums[idx] < nums[idx + 1]) {
                ++lenInc
                longest = maxOf(longest, lenInc)
            } else {
                lenInc = 1
            }
            if (nums[idx] > nums[idx + 1]) {
                ++lenDec
                longest = maxOf(longest, lenDec)
            } else {
                lenDec = 1
            }
        }

        return longest
    }
}