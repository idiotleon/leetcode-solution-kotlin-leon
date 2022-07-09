package com.an7one.leetcode.lvl4.lc1547

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 *
 * Time Complexity:     O(`n` ^ 3)
 * Space Complexity:    O(`n` ^ 2)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/780880/DP-with-picture-(Burst-Balloons)
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun minCost(n: Int, cuts: IntArray): Int {
        val padded = ArrayList<Int>().also {
            for (cut in cuts) it.add(cut)
            it.add(0)
            it.add(n)
            it.sort()
        }

        val nCuts = padded.size
        val dp = Array(nCuts) { IntArray(nCuts) { 0 } }
        for (lo in nCuts - 1 downTo 0) {
            for (hi in lo + 1 until nCuts) {
                for (k in lo + 1 until hi) {
                    dp[lo][hi] = minOf(
                        if (dp[lo][hi] == 0) Int.MAX_VALUE else dp[lo][hi],
                        padded[hi] - padded[lo] + dp[lo][k] + dp[k][hi]
                    )
                }
            }
        }

        return dp[0][nCuts - 1]
    }
}