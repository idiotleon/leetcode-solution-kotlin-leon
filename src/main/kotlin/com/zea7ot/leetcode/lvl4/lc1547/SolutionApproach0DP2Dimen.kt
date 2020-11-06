/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 *
 * Time Complexity:     O(`n` ^ 3)
 * Space Complexity:    O(`n` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/781074/JavaC%2B%2BPython-Merge-Stones
 *  https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/780880/DP-with-picture-(Burst-Balloons)
 */
package com.zea7ot.leetcode.lvl4.lc1547

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minCost(n: Int, cuts: IntArray): Int {
        val padded = ArrayList<Int>().also {
            for (cut in cuts) it.add(cut)
            it.add(0)
            it.add(n)
            it.sort()
        }

        val nCuts = padded.size
        val dp = Array(nCuts) { IntArray(nCuts) { 0 } }
        for (len in 2 until nCuts) {
            for (idx in 0 until nCuts - len) {
                dp[idx][idx + len] = Int.MAX_VALUE
                for (k in idx + 1 until idx + len) {
                    dp[idx][idx + len] = minOf(dp[idx][idx + len],
                            padded[idx + len] - padded[idx] + dp[idx][k] + dp[k][idx + len])
                }
            }
        }

        return dp[0][nCuts - 1]
    }
}