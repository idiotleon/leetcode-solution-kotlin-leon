/**
 * https://leetcode.com/problems/longest-mountain-in-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * 2 ~ 3 passes
 *
 * References:
 *  https://leetcode.com/problems/longest-mountain-in-array/discuss/135593/C%2B%2BJavaPython-1-pass-and-O(1)-space
 */
package com.zea7ot.leetcode.lvl3.lc0845

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers3 {
    fun longestMountain(nums: IntArray): Int {
        val nNums = nums.size
        if (nNums < 3) return 0

        val up = IntArray(nNums) { 0 }
        val down = IntArray(nNums) { 0 }
        var longest = 0

        for (idx in nNums - 2 downTo 0) {
            if (nums[idx] > nums[idx + 1]) {
                down[idx] = down[idx + 1] + 1
            }
        }

        for (idx in 0 until nNums) {
            if (idx > 0 && nums[idx - 1] < nums[idx]) {
                up[idx] = up[idx - 1] + 1
            }

            if (up[idx] > 0 && down[idx] > 0) {
                longest = maxOf(longest, up[idx] + down[idx] + 1)
            }
        }

        return longest
    }
}