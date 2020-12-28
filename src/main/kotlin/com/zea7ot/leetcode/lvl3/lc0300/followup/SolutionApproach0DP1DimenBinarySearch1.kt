/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://youtu.be/S9oUiVYEq7E
 *  https://leetcode.com/problems/longest-increasing-subsequence/solution/
 *  Paid Course, 12min: https://www.acwing.com/video/36/
 */
package com.zea7ot.leetcode.lvl3.lc0300.followup

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1DimenBinarySearch1 {
    fun lengthOfLIS(nums: IntArray): Int {
        // sanity check, required
        if (nums.isEmpty()) return 0

        val nNums = nums.size

        val dp = IntArray(nNums) { 0 }
        var len = 0

        for (num in nums) {
            var idx = lowerBound(0, len, dp, num)
            if (idx < 0) idx = -(idx + 1)
            dp[idx] = num
            if (idx == len) ++len
        }

        return len
    }

    /**
     * to find the the insertion position of the largest number that is smaller than the `target`
     */
    private fun lowerBound(low: Int, high: Int, tails: IntArray, target: Int): Int {
        var lo = low
        var hi = high

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (target > tails[mid]) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return lo
    }
}