/**
 * https://leetcode.com/problems/domino-and-tromino-tiling/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://youtu.be/S-fUTfqrdq8
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-790-domino-and-tromino-tiling/
 */
package com.zea7ot.leetcode.lvl4.lc0790

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun numTilings(N: Int): Int {
        if (N == 1) return 1

        val dp = LongArray(N + 1) { 1L }
        dp[2] = 2

        for (idx in 3..N) {
            dp[idx] = (dp[idx - 3] + dp[idx - 1] * 2) % MOD
        }

        return dp[N].toInt()
    }
}