/**
 * https://leetcode.com/problems/divide-array-into-increasing-sequences/
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/divide-array-into-increasing-sequences/discuss/510639/Java-beats-100-Less-Than-One-Pass-O(1)-Space
 */
package com.zea7ot.leetcode.lvl4.lc1121

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
private class SolutionApproach0BinarySearch {
    fun canDivideIntoSubsequences(nums: IntArray, K: Int): Boolean {
        val nNums = nums.size

        val freqLimit = nNums / K

        var idx = 0
        while (idx + freqLimit < nNums) {
            if (nums[idx] == nums[idx + freqLimit]) return false
            idx = lowerBound(idx, idx + 1, idx + freqLimit, nums)
        }

        return true
    }

    // to find the first bigger element/`num`
    private fun lowerBound(idx: Int, low: Int, high: Int, nums: IntArray): Int {
        var lo = low
        var hi = high

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] >= nums[idx]) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return lo
    }
}