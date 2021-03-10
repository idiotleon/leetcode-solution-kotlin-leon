/**
 * https://leetcode.com/problems/pizza-with-3n-slices/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/pizza-with-3n-slices/discuss/554171/Java-DP-Solution-Clear-Explanation-Clean-code
 */
package com.an7one.leetcode.lvl5.lc1388

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxSizeSlices(slices: IntArray): Int {
        val nSlices = slices.size
        val nonAdjacent = nSlices / 3

        val slices1 = slices.slice(0 until nSlices - 1)
        val slices2 = slices.slice(1 until nSlices)

        return maxOf(
            getMaxSlices(slices1, nonAdjacent),
            getMaxSlices(slices2, nonAdjacent)
        )
    }

    private fun getMaxSlices(slices: List<Int>, nonAdjacent: Int): Int {
        val nSlices = slices.size

        val dp = Array(1 + nSlices) { IntArray(1 + nonAdjacent) { 0 } }

        for (numSlices in 1..nSlices) {
            for (step in 1..nonAdjacent) {
                if (numSlices == 1) {
                    dp[numSlices][step] = slices[0]
                } else {
                    dp[numSlices][step] = maxOf(
                        dp[numSlices - 1][step],
                        dp[numSlices - 2][step - 1] + slices[numSlices - 1]
                    )
                }
            }
        }

        return dp[nSlices][nonAdjacent]
    }
}