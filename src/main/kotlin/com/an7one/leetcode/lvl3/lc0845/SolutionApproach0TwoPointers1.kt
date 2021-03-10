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
package com.an7one.leetcode.lvl3.lc0845

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

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