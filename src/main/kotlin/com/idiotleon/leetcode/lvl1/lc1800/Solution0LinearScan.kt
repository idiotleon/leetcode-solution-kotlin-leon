package com.idiotleon.leetcode.lvl1.lc1800

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-ascending-subarray-sum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun maxAscendingSum(nums: IntArray): Int {
        val nNums = nums.size

        var sum = nums[0]
        var largest = nums[0]
        for (idx in 0 until nNums - 1) {
            if (nums[idx] < nums[idx + 1]) {
                sum += nums[idx + 1]
                largest = maxOf(largest, sum)
            } else {
                sum = nums[idx + 1]
            }
        }

        return largest
    }
}