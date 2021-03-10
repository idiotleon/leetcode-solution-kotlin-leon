/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 110min: https://www.acwing.com/video/35/
 */
package com.an7one.summary.byAlgorithm.dynamicProgramming.interval

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP2DimenMergeStones {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
    }

    fun minCostMergeStones(): Int {
        val nInputs = readLine()!!.toInt()

        val stones = IntArray(nInputs + 1) { 0 }
        for (idx in 1..nInputs) {
            stones[idx] = readLine()!!.toInt()
        }

        val prefixSums = IntArray(nInputs + 1) { 0 }.also {
            for (idx in 1..nInputs) {
                it[idx] += it[idx - 1]
            }
        }

        val dp = Array(nInputs + 1) { IntArray(nInputs + 1) { DATA_RANGE } }
        for (len in 2..nInputs) {
            for (lo in 1..nInputs - len + 1) {
                val hi = lo + len - 1

                for (k in lo until hi) {
                    dp[lo][k] = minOf(
                        dp[lo][hi],
                        dp[lo][k] + dp[k + 1][hi] + (prefixSums[hi] - prefixSums[lo - 1])
                    )
                }
            }
        }

        return dp[1][nInputs]
    }
}