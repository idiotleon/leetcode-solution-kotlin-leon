package com.idiotleon.leetcode.lvl4.lc0646

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 *
 * Time Complexity:     O(`nPairs` ^ 2)
 * Space Complexity:    O(`nPairs`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105602/easy-dp/108158
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        // sanity check
        if (pairs.isEmpty()) return 0

        val nPairs = pairs.size
        pairs.sortWith(compareBy({ it[0] }, { it[1] }))

        val dp = IntArray(nPairs) { 1 }
        var longest = 0

        for (hi in 1 until nPairs) {
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