/**
 * @author: Leon
 * https://leetcode.com/problems/rotate-array/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0189

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun rotate(nums: IntArray, k: Int) {
        val totalNums = nums.size
        val steps = k % totalNums

        reverse(0, totalNums, nums)
        reverse(0, steps, nums)
        reverse(steps, totalNums, nums)
    }

    private fun reverse(low: Int, high: Int, nums: IntArray) {
        var lo = low
        var hi = high - 1

        while (lo < hi) {
            val temp = nums[lo]
            nums[lo] = nums[hi]
            nums[hi] = temp

            ++lo
            --hi
        }
    }
}