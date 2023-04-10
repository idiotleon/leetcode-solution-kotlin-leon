package com.idiotleon.leetcode.lvl4.lc0354

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * Time Complexity:     O(`nEnvelopes` ^ 2)
 * Space Complexity:    O(`nEnvelopes`)
 *
 * Reference:
 * https://leetcode.com/problems/russian-doll-envelopes/discuss/82759/Simple-DP-solution/86996
 * https://leetcode.com/problems/russian-doll-envelopes/discuss/82759/Simple-DP-solution
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        val nEnvelopes = envelopes.size

        envelopes.sortBy { it[0] }

        val dp = IntArray(nEnvelopes) { 1 }
        var most = 0

        for (hi in envelopes.indices) {
            val outer = envelopes[hi]
            for (lo in 0 until hi) {
                val inner = envelopes[lo]

                if (outer[0] > inner[0] && outer[1] > inner[1]) {
                    dp[hi] = maxOf(dp[hi], 1 + dp[lo])
                }
            }

            most = maxOf(most, dp[hi])
        }

        return most
    }
}