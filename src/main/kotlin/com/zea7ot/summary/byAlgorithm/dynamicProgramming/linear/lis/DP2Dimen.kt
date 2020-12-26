/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 42min: https://www.acwing.com/video/35/
 */
package com.zea7ot.summary.byAlgorithm.dynamicProgramming.linear.lis

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP2Dimen {
    private companion object {
        private const val DATA_RANGE = 1e3.toInt() + 7
    }

    private val nums = IntArray(DATA_RANGE) { 0 }
    private val dp = IntArray(DATA_RANGE) { 0 }

    fun main(): Int {
        val nInputs = readLine()!!.toInt()

        for (idx in 1..nInputs) nums[idx] = readLine()!!.toInt()

        for (hi in 1..nInputs) {
            dp[hi] = 1
            for (lo in 1 until hi) {
                if (nums[lo] < nums[hi]) {
                    dp[hi] = maxOf(dp[hi], 1 + dp[lo])
                }
            }
        }

        var longest = 1
        for (idx in 1..nInputs) {
            longest = maxOf(longest, dp[idx])
        }
        return longest
    }
}