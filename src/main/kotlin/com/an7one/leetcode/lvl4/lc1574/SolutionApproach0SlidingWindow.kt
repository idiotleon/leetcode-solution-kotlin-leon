package com.an7one.leetcode.lvl4.lc1574

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/discuss/830480/C%2B%2B-O(N)-Sliding-window-Explanation-with-Illustrations
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun findLengthOfShortestSubarray(nums: IntArray): Int {
        val nNums = nums.size

        var left = 0
        var right = nNums - 1

        while (left + 1 < nNums && nums[left] <= nums[left + 1]) ++left
        if (left == nNums - 1) return 0

        while (left < right && nums[right - 1] <= nums[right]) --right

        var min = minOf(nNums - left - 1, right)

        var lo = 0
        var hi = right

        while (lo <= left && hi < nNums) {
            if (nums[lo] <= nums[hi]) {
                min = minOf(min, hi - lo - 1)
                ++lo
            } else {
                ++hi
            }
        }

        return min
    }
}