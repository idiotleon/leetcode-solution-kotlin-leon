package com.idiotleon.leetcode.lvl3.lc0300.followup

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * Paid Course, 17min: https://www.acwing.com/video/36/
 */
@Suppress(UNUSED)
class SolutionApproach0DP1DimenBinarySearch {
    private companion object {
        private const val VALUE_RANGE = 1e4.toInt() + 7
    }

    fun lengthOfLIS(nums: IntArray): Int {
        val nNums = nums.size

        // to pad one spot longer at the tail
        val dp = IntArray(nNums + 1) { 0 }.also {
            it[0] = -VALUE_RANGE
        }

        var len = 0

        for (num in nums) {
            var lo = 0
            var hi = len

            while (lo < hi) {
                val mid = lo + hi + 1 shr 1

                if (dp[mid] < num) {
                    lo = mid
                } else {
                    hi = mid - 1
                }
            }

            len = maxOf(len, hi + 1)
            dp[hi + 1] = num
        }

        return len
    }
}