package com.idiotleon.leetcode.lvl2.lc1991

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun findMiddleIndex(nums: IntArray): Int {
        val nNums = nums.size
        val totalSum = nums.sum()

        var sum = 0

        for ((idx, num) in nums.withIndex()) {
            if (sum == totalSum - sum - num) {
                return idx
            }

            sum += num
        }

        return -1
    }
}