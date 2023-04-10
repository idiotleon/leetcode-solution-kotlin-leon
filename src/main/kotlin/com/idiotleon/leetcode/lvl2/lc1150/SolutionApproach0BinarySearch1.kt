/**
 * @author: Leon
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc1150

class SolutionApproach0BinarySearch1 {
    fun isMajorityElement(nums: IntArray, target: Int): Boolean {
        val nNums = nums.size

        val lo = lowerBound(target, nums)
        val hi = lowerBound(target + 1, nums)

        val len = hi - lo

        return len > nNums / 2
    }

    private fun lowerBound(target: Int, nums: IntArray): Int {
        val nNums = nums.size

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] >= target)
                hi = mid
            else
                lo = mid + 1
        }

        return lo
    }
}