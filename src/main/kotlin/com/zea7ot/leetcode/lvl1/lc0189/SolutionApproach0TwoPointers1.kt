/**
 * @author: Leon
 * https://leetcode.com/problems/rotate-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0189

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers1 {
    fun rotate(nums: IntArray, k: Int) {
        val nNums = nums.size
        val idxRotate = nNums - k % nNums - 1

        // the order of the below three lines matters here
        reverse(0, idxRotate, nums)
        reverse(idxRotate + 1, nNums - 1, nums)
        reverse(0, nNums - 1, nums)
    }

    private fun reverse(low: Int, high: Int, nums: IntArray) {
        var lo = low
        var hi = high

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