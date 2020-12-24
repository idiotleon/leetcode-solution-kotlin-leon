/**
 * @author: Leon
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
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
class DP2Dimen {
    fun getMaxValue(nItems: Int, packTotalVolume: Int): Int {

        // assuming that all volumes have been assigned/given
        val itemVolumes = IntArray(nItems + 1) { 0 }

        // assuming that all values/weights have been assigned/given
        val itemWeights = IntArray(nItems + 1) { 0 }

        val dp = Array(nItems + 1) { IntArray(packTotalVolume + 1) { 0 } }
        // initialization:
        //  dp[0][0] ~ dp[0][packTotalVolume] = 0s
        // which means, when 0 item has been taken, no matter how large the volume of the pack is,
        // the values/weights always are 0

        for (curItem in 1..nItems) {
            for (curPackVolume in 0..packTotalVolume) {
                dp[curItem][curPackVolume] = dp[curItem - 1][curPackVolume]
                if (curPackVolume >= itemVolumes[curItem]) {
                    dp[curItem][curPackVolume] =
                        maxOf(
                            dp[curItem][curPackVolume],
                            dp[curItem - 1][curPackVolume - itemVolumes[curItem]] + itemWeights[curItem]
                        )
                }
            }
        }

        return dp[nItems][packTotalVolume]
    }
}