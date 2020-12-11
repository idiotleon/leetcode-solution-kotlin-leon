/**
 * https://leetcode.com/problems/number-of-music-playlists/
 *
 * Time Complexity:     O(`L` * `N`)
 * Space Complexity:    O(`L` * `N`)
 *
 * dp[l][n], number of playlists of length `l` with `n` different songs
 *  dp[l][n] = dp[l - 1][n - 1] * (N - (n - 1)) + dp[l - 1][n] * max(n - K, 0)
 *  1. to add a new song: dp[l - 1][n - 1] * (N - (n - 1))
 *      with n - 1 used, to pick any one from the remaining (N - (n - 1))
 *  2. to reuse an existing song: dp[l - 1][n] * max(N - K, 0)
 *
 * References:
 *  https://leetcode.com/problems/number-of-music-playlists/discuss/180338/DP-solution-that-is-Easy-to-understand
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-920-number-of-music-playlists/
 *  https://leetcode.com/problems/number-of-music-playlists/discuss/180338/DP-solution-that-is-Easy-to-understand/231158
 */
package com.zea7ot.leetcode.lvl5.lc0920

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun numMusicPlaylists(N: Int, L: Int, K: Int): Int {
        val dp = Array(L + 1) { LongArray(N + 1) { 0L } }.also { it[0][0] = 1L }

        for (idxL in 1..L) {
            for (idxN in 1..N) {
                dp[idxL][idxN] = (dp[idxL - 1][idxN - 1]) * (N - (idxN - 1)) % MOD

                if (idxN > K) {
                    dp[idxL][idxN] = (dp[idxL][idxN] + (dp[idxL - 1][idxN]) * (idxN - K) % MOD) % MOD
                }
            }
        }

        return dp[L][N].toInt()
    }
}