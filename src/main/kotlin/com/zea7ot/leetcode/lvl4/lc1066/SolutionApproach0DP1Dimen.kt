/**
 * https://leetcode.com/problems/campus-bikes-ii/
 *
 * Time Complexity:     O(`1 << totalBikes` * `totalBikes`)
 * Space Complexity:    O(`1 << totalBikes`)
 *
 * References:
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/311331/Java-DFS-with-memorization!Very-666
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/303417/Python-Bit-Mask-DP
 *  https://leetcode.com/problems/campus-bikes-ii/discuss/360037/Step-by-Step-solution-from-400ms-to-1ms-(beating-100)
 */
package com.zea7ot.leetcode.lvl4.lc1066

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    @ExperimentalStdlibApi
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        var min = Int.MAX_VALUE

        val totalWorkers = workers.size
        val totalBikes = bikes.size
        val totalStates = 1 shl totalBikes

        val dp = IntArray(totalStates)

        for (state in 1 until totalStates) {
            val idxWorker = state.countOneBits()
            if (idxWorker > totalWorkers) continue

            dp[state] = Int.MAX_VALUE
            for (idxBike in 0 until totalBikes) {
                if ((state and (1 shl idxBike)) == 0) continue

                val prevState = state xor (1 shl idxBike)
                dp[state] = minOf(dp[state], dp[prevState] + getDistance(workers[idxWorker - 1], bikes[idxBike]))
            }

            if (idxWorker == totalWorkers) {
                min = minOf(min, dp[state])
            }
        }

        return min
    }

    private fun getDistance(worker: IntArray, bike: IntArray): Int {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1])
    }
}