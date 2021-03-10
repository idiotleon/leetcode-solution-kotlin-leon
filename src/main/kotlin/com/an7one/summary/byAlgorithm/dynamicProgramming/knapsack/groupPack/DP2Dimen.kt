/**
 * @author: Leon
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  Paid Course, 105min: https://www.acwing.com/video/34/
 */
package com.an7one.summary.byAlgorithm.dynamicProgramming.knapsack.groupPack

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP2Dimen {
    fun getMaxValue(
        nItems: Int,
        packTotalVolume: Int,
        itemVolumes: Array<IntArray>,
        itemWeights: Array<IntArray>,
        itemAmounts: IntArray
    ): Int {
        val dp = IntArray(nItems + 1) { 0 }

        for (curItem in 1..nItems) {
            for (curPackVolume in packTotalVolume downTo 0) {
                for (k in 0 until itemAmounts[curItem]) {
                    if (itemVolumes[curItem][k] <= curPackVolume) {
                        dp[curPackVolume] = maxOf(
                            dp[curPackVolume],
                            dp[curPackVolume - itemVolumes[curItem][k]] + itemWeights[curItem][k]
                        )
                    }
                }
            }
        }

        return dp[packTotalVolume]
    }
}