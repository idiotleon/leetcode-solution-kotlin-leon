package com.idiotleon.leetcode.lvl2.lc2110

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun getDescentPeriods(nums: IntArray): Long {
        val nNums = nums.size
        var count = 1L
        var len = 1
        for (idx in 1 until nNums) {
            if (nums[idx - 1] - 1 == nums[idx]) {
                ++len
            } else {
                len = 1
            }

            count += len
        }

        return count
    }
}