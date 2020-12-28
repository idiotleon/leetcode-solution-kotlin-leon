/**
 * @author: Leon
 *
 * this is similar to Knapsack - Complete Pack
 *
 * References:
 *  Paid Course, 63min: https://www.acwing.com/video/36/
 */
package com.zea7ot.summary.byAlgorithm.dynamicProgramming.digit

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class Knapsack1Dimen {
    private companion object {
        private const val DATA_RANGE = 1e3.toInt() + 7
        private const val MOD = 1e9.toInt() + 7
    }

    fun main(): Int {
        val num = readLine()!!.toInt()
        val dp = IntArray(DATA_RANGE) { 0 }.also {
            it[0] = 1
        }

        for (lo in 1..num) {
            for (hi in lo..num) {
                dp[hi] = (dp[hi] + dp[hi - lo]) % MOD
            }
        }

        return dp[num]
    }
}