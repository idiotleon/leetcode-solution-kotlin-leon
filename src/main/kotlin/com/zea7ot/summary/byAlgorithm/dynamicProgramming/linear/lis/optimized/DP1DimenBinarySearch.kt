/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 17min: https://www.acwing.com/video/36/
 */
package com.zea7ot.summary.byAlgorithm.dynamicProgramming.linear.lis.optimized

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP1DimenBinarySearch {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
        private const val VALUE_RANGE = 1e9.toInt() + 7
    }

    private val nums = IntArray(DATA_RANGE) { 0 }
    private val dp = IntArray(DATA_RANGE) { 0 }.also {
        it[0] = -VALUE_RANGE
    }

    fun main(): Int {
        val nInputs = readLine()!!.toInt()

        for (i in 0 until nInputs) {
            nums[i] = readLine()!!.toInt()
        }

        var len = 0

        for (idx in 0 until nInputs) {
            var lo = 0
            var hi = len

            while (lo < hi) {
                val mid = lo + hi + 1 shr 1

                if (dp[mid] < nums[idx]) lo = mid
                else hi = mid - 1
            }

            len = maxOf(len, hi + 1)
            dp[hi + 1] = nums[idx]
        }

        return len
    }
}