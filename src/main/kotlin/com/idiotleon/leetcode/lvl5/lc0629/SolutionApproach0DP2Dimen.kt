/**
 * https://leetcode.com/problems/k-inverse-pairs-array/
 *
 * Time Complexity:     O(`n` * `k`)
 * Space Complexity:    O(`n` * `k`)
 *
 * Reference:
 *  https://leetcode.com/problems/k-inverse-pairs-array/discuss/104815/Java-DP-O(nk)-solution
 */
package com.idiotleon.leetcode.lvl5.lc0629

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toLong() + 7
    }

    fun kInversePairs(n: Int, k: Int): Int {
        if (k > n * (n - 1) / 2 || k < 0)
            return 0

        if (k == 0 || k == n * (n - 1) / 2)
            return 1

        val dp = Array(n + 1) { LongArray(k + 1) { 0L } }.also {
            it[2][0] = 1L
            it[2][1] = 1L
        }

        for (row in 3..n) {
            dp[row][0] = 1L

            for (col in 1..minOf(k, row * (row - 1) / 2)) {
                dp[row][col] = dp[row][col - 1] + dp[row - 1][col]

                if (col >= row)
                    dp[row][col] -= dp[row - 1][col - row]

                dp[row][col] = (dp[row][col] + MOD) % MOD
            }
        }

        return dp[n][k].toInt()
    }
}