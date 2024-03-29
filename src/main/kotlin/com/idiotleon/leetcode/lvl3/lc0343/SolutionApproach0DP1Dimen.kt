package com.idiotleon.leetcode.lvl3.lc0343

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/integer-break/
 *
 * Time Complexity:     O(`n` ^ 2)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://leetcode.com/problems/integer-break/discuss/80694/Java-DP-solution/204792
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun integerBreak(n: Int): Int {
        val dp = IntArray(n + 1).also {
            it[1] = 1
        }
        for (hi in 2..n) {
            for (lo in 1..hi / 2) {
                dp[hi] = maxOf(
                    dp[hi],
                    //let's say i = 8, we are trying to fill dp[8]:
                    // if 8 can only be broken into 2 parts,
                    // the answer could be among 1 * 7, 2 * 6, 3 * 5, 4 * 4...
                    // but these numbers can be further broken.
                    // so we have to compare 1 with dp[1], 7 with dp[7], 2 with dp[2], 6 with dp[6]...etc
                    maxOf(lo, dp[lo]) * maxOf(hi - lo, dp[hi - lo])
                )
            }
        }

        return dp[n]
    }
}