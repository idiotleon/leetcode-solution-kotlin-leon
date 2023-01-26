package com.an7one.leetcode.lvl5.lc0920

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-music-playlists/
 *
 * Time Complexity:     O(`L` * `N`)
 * Space Complexity:    O(`L`)
 *
 * Reference:
 * https://leetcode.com/problems/number-of-music-playlists/discuss/180338/DP-solution-that-is-Easy-to-understand/262616
 * https://leetcode.com/problems/number-of-music-playlists/discuss/180338/DP-solution-that-is-Easy-to-understand
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-920-number-of-music-playlists/
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun numMusicPlaylists(N: Int, L: Int, K: Int): Int {
        val dp = LongArray(N + 1) { 0L }.also { it[1] = N.toLong() }

        for (p in 2..L) {
            for (s in minOf(N, p) downTo 1) {
                dp[s] = (dp[s - 1] * (N - s + 1) + dp[s] * maxOf(s - K, 0)) % MOD
            }
        }

        return dp[N].toInt()
    }
}