/**
 * @author: Leon
 * https://leetcode.com/problems/rotate-array/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl1.lc0189

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun rotate(nums: IntArray, k: Int) {
        val nNums = nums.size
        val steps = k % nNums

        // the order of the below three lines matters here
        reverse(0, nNums, nums)
        reverse(0, steps, nums)
        reverse(steps, nNums, nums)
    }

    private fun reverse(low: Int, high: Int, nums: IntArray) {
        var lo = low
        var hi = high - 1

        while (lo < hi) {
            swap(lo, hi, nums)
            ++lo
            --hi
        }
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}