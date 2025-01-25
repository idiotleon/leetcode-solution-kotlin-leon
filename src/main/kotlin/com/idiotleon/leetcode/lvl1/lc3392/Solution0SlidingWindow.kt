package com.idiotleon.leetcode.lvl1.lc3392

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    fun countSubarrays(nums: IntArray): Int {
        val nNums = nums.size

        var count = 0
        for (idx in 1 until nNums - 1) {
            if (nums[idx] == (nums[idx - 1] + nums[idx + 1]) * 2) {
                ++count
            }
        }

        return count
    }
}