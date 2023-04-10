/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2`)
 *
 *  `dp[i][j]`, the minimum deletion for `str1.substring(0, i)`, i-th char exclusive,
 *  and `str2.substring(0, j)`, j-th char exclusive
 *
 * References:
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/108811/JavaDP(With-Explanation)/300816
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/642422/for-those-who-have-no-clue-%3A-step-by-step
 */
package com.idiotleon.leetcode.lvl3.lc0712

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val len1 = s1.length
        val len2 = s2.length

        val dp = Array(len1 + 1) { IntArray(len2 + 1) { 0 } }

        // to initialize the `dp` 2d array with `s1`
        for (idx1 in 1..len1) {
            dp[idx1][0] = dp[idx1 - 1][0] + s1[idx1 - 1].toInt()
        }

        // to initialize the `dp` 2d array with `s2`
        for (idx2 in 1..len2) {
            dp[0][idx2] = dp[0][idx2 - 1] + s2[idx2 - 1].toInt()
        }

        for (idx1 in 1..len1) {
            for (idx2 in 1..len2) {
                dp[idx1][idx2] = if (s1[idx1 - 1] == s2[idx2 - 1]) {
                    dp[idx1 - 1][idx2 - 1]
                } else {
                    minOf(dp[idx1 - 1][idx2] + s1[idx1 - 1].toInt(), dp[idx1][idx2 - 1] + s2[idx2 - 1].toInt())
                }
            }
        }

        return dp[len1][len2]
    }
}