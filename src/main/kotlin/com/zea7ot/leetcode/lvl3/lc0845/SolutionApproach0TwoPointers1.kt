/**
 * https://leetcode.com/problems/longest-mountain-in-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * One Pass
 *
 * References:
 *  https://leetcode.com/problems/longest-mountain-in-array/discuss/165667/1-pass-Java-Two-Point-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0845

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers1 {
    fun longestMountain(nums: IntArray): Int {
        val totalNums = nums.size
        if (totalNums < 3) return 0

        var lo = 0
        var hi: Int
        var longest = 0

        while (lo < totalNums - 2) {
            // to initialize the position
            while (lo < totalNums - 1 && nums[lo] >= nums[lo + 1]) {
                ++lo
            }
            hi = lo + 1

            // up hill
            while (hi < totalNums - 1 && nums[hi] < nums[hi + 1]) {
                ++hi
            }

            // down hill
            while (hi < totalNums - 1 && nums[hi] > nums[hi + 1]) {
                ++hi
                longest = maxOf(longest, hi - lo + 1)
            }

            lo = hi
        }

        return longest
    }
}