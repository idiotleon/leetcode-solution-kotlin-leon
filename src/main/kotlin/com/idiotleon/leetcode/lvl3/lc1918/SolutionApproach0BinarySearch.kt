package com.idiotleon.leetcode.lvl3.lc1918

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/kth-smallest-subarray-sum/
 *
 * Time Complexity:     O(`nNums` * lg(`RANGE_DATA`))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/kth-smallest-subarray-sum/discuss/1309749/Binary-Search-%2B-Sliding-Window
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    private companion object {
        private const val RANGE_DATA = 2e4.toInt() * 5e4.toInt()
    }

    fun kthSmallestSubarraySum(nums: IntArray, k: Int): Int {
        // not used
        // val nNums = nums.size

        var lo = 1
        var hi = RANGE_DATA

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            val count = getCount(nums, mid)

            if (count < k) lo = mid + 1
            else hi = mid
        }

        return lo
    }

    private fun getCount(nums: IntArray, target: Int): Int {
        val nNums = nums.size

        var lo = 0
        var hi = 0
        var sum = 0
        var count = 0

        while (hi < nNums) {
            if (sum + nums[hi] <= target) {
                sum += nums[hi]
                count += hi - lo + 1
                ++hi
            } else {
                sum -= nums[lo]
                ++lo
            }
        }

        return count
    }
}