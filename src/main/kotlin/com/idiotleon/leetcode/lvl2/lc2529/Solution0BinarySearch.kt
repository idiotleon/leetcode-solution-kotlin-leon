package com.idiotleon.leetcode.lvl2.lc2529

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0BinarySearch {
    fun maximumCount(nums: IntArray): Int {
        val nNums = nums.size
        val positiveLowerBound = getLowerBound(nums)
        val negativeUpperBound = getUpperBound(nums)

        return maxOf(negativeUpperBound + 1, nNums - positiveLowerBound)
    }

    private fun getLowerBound(nums: IntArray): Int {
        val nNums = nums.size
        var lo = 0
        var hi = nNums
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (nums[mid] >= 1) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }
        return lo
    }

    private fun getUpperBound(nums: IntArray): Int {
        val nNums = nums.size

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] <= -1) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return hi - 1
    }
}