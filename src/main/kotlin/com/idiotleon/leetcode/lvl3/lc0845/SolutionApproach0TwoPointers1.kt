package com.idiotleon.leetcode.lvl3.lc0845

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-mountain-in-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * One Pass
 *
 * Reference:
 * https://leetcode.com/problems/longest-mountain-in-array/discuss/165667/1-pass-Java-Two-Point-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers1 {
    fun longestMountain(nums: IntArray): Int {
        val nNums = nums.size
        if (nNums < 3) return 0

        var lo = 0
        var hi: Int
        var longest = 0

        while (lo < nNums - 2) {
            // to initialize the position
            while (lo < nNums - 1 && nums[lo] >= nums[lo + 1]) {
                ++lo
            }
            hi = lo + 1

            // up hill
            while (hi < nNums - 1 && nums[hi] < nums[hi + 1]) {
                ++hi
            }

            // down hill
            while (hi < nNums - 1 && nums[hi] > nums[hi + 1]) {
                ++hi
                longest = maxOf(longest, hi - lo + 1)
            }

            lo = hi
        }

        return longest
    }
}