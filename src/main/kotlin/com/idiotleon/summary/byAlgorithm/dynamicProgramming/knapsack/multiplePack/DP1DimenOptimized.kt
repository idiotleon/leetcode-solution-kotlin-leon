/**
 * @author: Leon
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  Paid Course, 100min: https://www.acwing.com/video/34/
 */
package com.idiotleon.summary.byAlgorithm.dynamicProgramming.knapsack.multiplePack

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP1DimenOptimized {
    private companion object {
        private const val DATA_RANGE = 25000
    }

    // assuming that all volumes have been assigned/given
    private val itemVolumes = IntArray(DATA_RANGE) { 0 }

    // assuming that all values/weights have been assigned/given
    private val itemWeights = IntArray(DATA_RANGE) { 0 }

    fun getMaxValue(nItems: Int, packTotalVolume: Int): Int {
        var nItems = nItems

        var count = 0
        for (idx in 1..nItems) {
            val itemVolume = readLine()!!.toInt()
            val itemWeight = readLine()!!.toInt()
            var itemAmount = readLine()!!.toInt()

            var k = 1
            while (k <= itemAmount) {
                ++count
                itemVolumes[count] = k * itemVolume
                itemWeights[count] = k * itemWeight
                itemAmount -= k
                k *= 2
            }

            if (itemAmount > 0) {
                ++count
                itemVolumes[count] = itemAmount * itemVolume
                itemWeights[count] = itemAmount * itemWeight
            }
        }

        nItems = count

        // 0/1 knapsack
        val dp = IntArray(nItems + 1) { 0 }
        for (curItem in 1..nItems) {
            for (curPackVolume in packTotalVolume downTo itemVolumes[curItem]) {
                dp[curPackVolume] =
                    maxOf(
                        dp[curPackVolume],
                        dp[curPackVolume - itemVolumes[curItem]] + itemWeights[curItem]
                    )
            }
        }

        return dp[packTotalVolume]
    }
}