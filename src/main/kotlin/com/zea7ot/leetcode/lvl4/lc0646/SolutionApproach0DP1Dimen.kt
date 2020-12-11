/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 *
 * Time Complexity:     O(`totalPairs` ^ 2)
 * Space Complexity:    O(`totalPairs`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105602/easy-dp/108158
 */
package com.zea7ot.leetcode.lvl4.lc0646

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        // sanity check
        if (pairs.isEmpty()) return 0

        val totalPairs = pairs.size
        pairs.sortWith(compareBy({ it[0] }, { it[1] }))

        val dp = IntArray(totalPairs) { 1 }
        var longest = 0

        for (hi in 1 until totalPairs) {
            for (lo in hi - 1 downTo 0) {
                if (pairs[hi][0] > pairs[lo][1]) {
                    dp[hi] = maxOf(dp[hi], dp[lo] + 1)
                }
            }

            longest = maxOf(longest, dp[hi])
        }

        return longest
    }
}