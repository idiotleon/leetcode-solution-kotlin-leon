package com.idiotleon.leetcode.lvl3.lc0845

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-mountain-in-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/longest-mountain-in-array/discuss/135593/C++JavaPython-1-pass-and-O(1)-space/142630
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun longestMountain(nums: IntArray): Int {
        val nNums = nums.size
        if (nNums < 3) return 0

        var longest = 0

        var idx = 1
        while (idx < nNums) {
            while (idx < nNums && nums[idx - 1] >= nums[idx]) {
                ++idx
            }

            var up = 0
            while (idx < nNums && nums[idx - 1] < nums[idx]) {
                ++up
                ++idx
            }

            var down = 0
            while (idx < nNums && nums[idx - 1] > nums[idx]) {
                ++down
                ++idx
            }

            if (up > 0 && down > 0) {
                longest = maxOf(longest, up + down + 1)
            }
        }

        return longest
    }
}