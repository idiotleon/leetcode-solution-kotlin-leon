/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * Time Complexity:     O(`totalEnvelopes` ^ 2)
 * Space Complexity:    O(`totalEnvelopes`)
 *
 * References:
 *  https://leetcode.com/problems/russian-doll-envelopes/discuss/82759/Simple-DP-solution
 *  https://www.geeksforgeeks.org/box-stacking-problem-dp-22/
 */
package com.zea7ot.leetcode.lvl5.lc0354

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        val totalEnvelopes = envelopes.size
        envelopes.sortBy { it[0] }

        val dp = IntArray(totalEnvelopes) { 1 }
        var most = 0

        for (hi in 0 until totalEnvelopes) {
            val outer = envelopes[hi]
            for (lo in 0 until hi) {
                val inner = envelopes[lo]

                if (outer[0] > inner[0] && outer[1] > inner[1]) { // if `inner` can be fit into `outer`
                    dp[hi] = maxOf(dp[hi], dp[lo] + 1)
                }
            }

            most = maxOf(most, dp[hi])
        }

        return most
    }
}