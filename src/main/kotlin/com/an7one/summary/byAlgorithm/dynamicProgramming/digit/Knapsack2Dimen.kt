/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 75min: https://www.acwing.com/video/36/
 */
package com.an7one.summary.byAlgorithm.dynamicProgramming.digit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class Knapsack2Dimen {
    private companion object {
        private const val DATA_RANGE = 1e3.toInt() + 7
        private const val MOD = 1e9.toInt() + 7
    }

    fun main(): Int {
        val num = readLine()!!.toInt()
        val dp = Array(DATA_RANGE) { IntArray(DATA_RANGE) { 0 } }

        for (hi in 1..num) {
            for (lo in 1..hi) {
                dp[lo][hi] = (dp[hi - 1][lo - 1] + dp[hi - lo][lo]) % MOD
            }
        }

        var sum = 0
        for (idx in 1..num) {
            sum += dp[num][idx] % MOD
            sum %= MOD
        }

        return sum
    }
}