package com.idiotleon.leetcode.lvl2.lc1752

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/solutions/1053508/java-c-python-easy-and-concise/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun check(nums: IntArray): Boolean {
        val nNums = nums.size

        // count of decreasing subarray/segment
        var count = 0

        for (idx in 0 until nNums) {
            if (nums[idx] > nums[(idx + 1) % nNums]) {
                ++count
            }
            if (count > 1) {
                return false
            }
        }

        return true
    }
}