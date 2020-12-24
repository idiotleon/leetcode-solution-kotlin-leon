/**
 * @author: Leon
 *
 * Time Complexity:     O(`nItems` * `packTotalVolume`)
 * Space Complexity:    O(`packTotalVolume`)
 *
 * f(i, j) = max(f(i - 1, j), f(i - 1, j - V_i) + W_i)
 *  i, to select only from the previous `i` items
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/34/
 */
package com.zea7ot.summary.byAlgorithm.dynamicProgramming.knapsack.zeroOneKnapsack

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP1Dimen {
    fun getMaxValue(nItems: Int, packTotalVolume: Int): Int {
        // assuming that all volumes have been assigned/given
        val volumes = IntArray(nItems + 1) { 0 }

        // assuming that all values/weights have been assigned/given
        val weights = IntArray(nItems + 1) { 0 }

        val dp = IntArray(packTotalVolume + 1) { 0 }
        // initialization:
        //  dp[0] ~ dp[packTotalVolume] = 0s
        // which means, when 0 item has been taken, no matter how large the volume of the pack is,
        // the values/weights always are 0

        for (curItem in 1..nItems) {
            /*
             * the reason for reversed loop, is because that,
             *  in 1D version, dp[curPackVolume - volumes[curItem]], is equal to,
             *  in 2D version, dp[curItem - 1][curPackVolume - volumes[curItem]]
             */
            for (curPackVolume in packTotalVolume downTo volumes[curItem]) {
                dp[curPackVolume] = maxOf(dp[curPackVolume], dp[curPackVolume - volumes[curItem]] + weights[curItem])
            }
        }

        return dp[packTotalVolume]
    }
}