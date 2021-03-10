/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 42min: https://www.acwing.com/video/35/
 */
package com.an7one.summary.byAlgorithm.dynamicProgramming.linear.lis

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP2Dimen1 {
    private companion object {
        private const val DATA_RANGE = 1e3.toInt() + 7
    }

    fun longestIncreasingSubsequence(nums: IntArray): Int {
        val nNums = nums.size

        var longest = 1

        val dp = IntArray(nNums) { 0 }

        for (hi in nums.indices) {
            dp[hi] = 1
            for (lo in 0 until hi) {
                if (nums[lo] < nums[hi]) {
                    dp[hi] = maxOf(dp[hi], 1 + dp[lo])
                    longest = maxOf(longest, dp[hi])
                }
            }
        }

        return longest
    }
}