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

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun numTilings(N: Int): Int {
        val dp = Array(N + 1) { LongArray(3) { 0 } }
        dp[0][0] = 1
        dp[1][0] = 1

        for (idx in 2..N) {
            dp[idx][0] = (dp[idx - 1][0] + dp[idx - 2][0] + 2 * dp[idx - 1][1]) % MOD
            dp[idx][1] = (dp[idx - 2][0] + dp[idx - 1][1]) % MOD
        }

        return dp[N][0].toInt()
    }
}