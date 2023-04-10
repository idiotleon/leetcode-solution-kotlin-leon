/**
 * @author: Leon
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * complete pack:
 *  f(i, j) = max(f(i - 1, j), f(i, j - v_i) + w_i)
 *
 * in comparison, 0/1 pack
 *  f(i, j) = max(f(i - 1, j), f(i - 1, j - v_i) + w_i_
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/34/
 */
package com.idiotleon.summary.byAlgorithm.dynamicProgramming.knapsack.completePack

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP2Dimen {
    fun getMaxValue(nItems: Int, packTotalVolume: Int): Int {
        // assuming that all volumes have been assigned/given
        val itemVolumes = IntArray(nItems + 1) { 0 }

        // assuming that all weights have been assigned/given
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
                    dp[curItem][curPackVolume] = maxOf(
                        dp[curItem][curPackVolume],
                        dp[curItem][curPackVolume - itemVolumes[curItem]] + itemWeights[curItem]
                    )
                }
            }
        }

        return dp[nItems][packTotalVolume]
    }
}