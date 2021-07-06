/**
 * https://leetcode.com/problems/count-vowels-permutation/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 *  https://leetcode.com/problems/count-vowels-permutation/discuss/398222/Detailed-Explanation-using-Graphs-With-Pictures-O(n)/358180
 *  https://leetcode.com/problems/count-vowels-permutation/discuss/398222/Detailed-Explanation-using-Graphs-With-Pictures-O(n)
 */
package com.an7one.leetcode.lvl4.lc1220

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toLong() + 7
    }

    fun countVowelPermutation(n: Int): Int {
        val dp = Array(n + 1) { LongArray(5) { 0L } }.also {
            for (col in 0 until 5) {
                it[1][col] = 1L
            }
        }

        for (row in 1 until n) {
            dp[row + 1][0] = (dp[row][4] + dp[row][1] + dp[row][2]) % MOD
            dp[row + 1][1] = (dp[row][0] + dp[row][2]) % MOD
            dp[row + 1][2] = (dp[row][3] + dp[row][1]) % MOD
            dp[row + 1][3] = dp[row][2] % MOD
            dp[row + 1][4] = (dp[row][2] + dp[row][3]) % MOD
        }

        return (dp[n].sum() % MOD).toInt()
    }
}