/**
 * @author: Leon
 *
 * Time Complexity:     O((`nItems` ^ 2) * `packTotalVolume`)
 * Space Complexity:    O(`nItems` * `packTotalVolume`)
 *
 * f(i, j) = max(f(i - 1, j - v_i * k + w_i * k)), k = 0, 1, 2, .., s_i
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/34/
 */
package com.an7one.summary.byAlgorithm.dynamicProgramming.knapsack.multiplePack

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP2Dimen1 {
    fun getMaxValue(nItems: Int, packTotalVolume: Int): Int {
        // assuming that all volumes have been assigned/given
        val itemVolumes = IntArray(nItems + 1) { 0 }

        // assuming that all values/weights have been assigned/given
        val itemWeights = IntArray(nItems + 1) { 0 }

        // assuming that all amounts of items have been assigned/given
        val itemAmounts = IntArray(nItems + 1) { 0 }

        val dp = Array(nItems + 1) { IntArray(packTotalVolume + 1) { 0 } }
        // initialization:
        //  dp[0][0] ~ dp[0][packTotalVolume] = 0s
        // which means, when 0 item has been taken, no matter how large the volume of the pack is,
        // the values/weights always are 0

        for (curItem in 1..nItems) {
            for (curPackVolume in 0..packTotalVolume) {
                var k = 0
                while (k <= itemAmounts[curItem] && k * itemVolumes[curItem] <= curPackVolume) {
                    dp[curItem][curPackVolume] = maxOf(
                        dp[curItem][curPackVolume],
                        dp[curItem - 1][curPackVolume - k * itemVolumes[curItem]] + k * itemWeights[curItem]
                    )

                    ++k
                }
            }
        }

        return dp[nItems][packTotalVolume]
    }
}