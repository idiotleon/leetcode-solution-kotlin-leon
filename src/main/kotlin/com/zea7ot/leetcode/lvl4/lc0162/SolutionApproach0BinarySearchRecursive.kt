/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * Time Complexity:     O(lg(`totalNums`))
 * Space Complexity:    O(lg(`totalNums`))
 */
package com.zea7ot.leetcode.lvl4.lc0162

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

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