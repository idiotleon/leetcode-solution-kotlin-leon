package com.an7one.leetcode.lvl4.lc0162

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-peak-element/
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(lg(`nNums`))
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearchRecursive {
    fun findPeakElement(nums: IntArray): Int {
        val nNums = nums.size

        return binarySearch(0, nNums - 1, nums)
    }

    private fun binarySearch(lo: Int, hi: Int, nums: IntArray): Int {
        if (lo == hi) return lo

        val mid = lo + (hi - lo) / 2
        return if (nums[mid] > nums[mid + 1]) {
            binarySearch(lo, mid, nums)
        } else {
            binarySearch(mid + 1, hi, nums)
        }
    }
}