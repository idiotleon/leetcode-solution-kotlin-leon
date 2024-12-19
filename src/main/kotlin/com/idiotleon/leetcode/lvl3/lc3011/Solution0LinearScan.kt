package com.idiotleon.leetcode.lvl3.lc3011

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-if-array-can-be-sorted/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/find-if-array-can-be-sorted/solutions/5966914/find-if-array-can-be-sorted/comments/2709658
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun canSortArray(nums: IntArray): Boolean {
        val nNums = nums.size

        var countBits = 0
        var curMax = 0
        var prevMax = 0

        for (num in nums) {
            val count = num.countOneBits()
            if (count != countBits) {
                countBits = count
                prevMax = curMax
            }
            if (prevMax > num) {
                return false
            }
            curMax = maxOf(curMax, num)
        }

        return true
    }
}