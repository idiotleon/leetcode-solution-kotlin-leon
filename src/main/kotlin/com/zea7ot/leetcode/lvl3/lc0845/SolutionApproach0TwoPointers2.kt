/**
 * https://leetcode.com/problems/longest-mountain-in-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/longest-mountain-in-array/discuss/135593/C%2B%2BJavaPython-1-pass-and-O(1)-space
 */
package com.zea7ot.leetcode.lvl3.lc0845

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers2 {
    fun longestMountain(nums: IntArray): Int {
        val nNums = nums.size
        if (nNums < 3) return 0

        var up = 0
        var down = 0
        var longest = 0

        for (idx in 1 until nNums) {
            if (down > 0 && nums[idx - 1] < nums[idx] || nums[idx - 1] == nums[idx]) {
                up = 0
                down = 0
            }

            if (nums[idx - 1] < nums[idx]) ++up
            if (nums[idx - 1] > nums[idx]) ++down

            if (up > 0 && down > 0 && up + down + 1 > longest) {
                longest = up + down + 1
            }
        }

        return longest
    }
}