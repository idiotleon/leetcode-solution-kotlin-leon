package com.an7one.leetcode.lvl4.lc1066

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/campus-bikes-ii/
 *
 * Time Complexity:     O(`1 << totalBikes` * `totalBikes`)
 * Space Complexity:    O(`1 << totalBikes`)
 *
 * Reference:
 * https://leetcode.com/problems/campus-bikes-ii/discuss/311331/Java-DFS-with-memorization!Very-666
 * https://leetcode.com/problems/campus-bikes-ii/discuss/303417/Python-Bit-Mask-DP
 * https://leetcode.com/problems/campus-bikes-ii/discuss/360037/Step-by-Step-solution-from-400ms-to-1ms-(beating-100)
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    @ExperimentalStdlibApi
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        var min = Int.MAX_VALUE

        val nWorkers = workers.size
        val nBikes = bikes.size
        val nStates = 1 shl nBikes

        val dp = IntArray(nStates)

        for (state in 1 until nStates) {
            val idxWorker = state.countOneBits()
            if (idxWorker > nWorkers) continue

            dp[state] = Int.MAX_VALUE
            for (idxBike in 0 until nBikes) {
                if ((state and (1 shl idxBike)) == 0) continue

                val prevState = state xor (1 shl idxBike)
                dp[state] = minOf(dp[state], dp[prevState] + getDistance(workers[idxWorker - 1], bikes[idxBike]))
            }

            if (idxWorker == nWorkers) {
                min = minOf(min, dp[state])
            }
        }

        return min
    }

    private fun getDistance(worker: IntArray, bike: IntArray): Int {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1])
    }
}