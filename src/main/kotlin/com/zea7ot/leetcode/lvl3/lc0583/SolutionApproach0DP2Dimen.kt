/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2`)
 *
 * References:
 *  https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)/106401
 */
package com.zea7ot.leetcode.lvl3.lc0583

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minDistance(word1: String, word2: String): Int {
        val len1 = word1.length
        val len2 = word2.length

        val dp = Array(len1 + 1) { IntArray(len2 + 1) { 0 } }
        for (idx1 in 1..len1) {
            for (idx2 in 1..len2) {
                if (word1[idx1 - 1] == word2[idx2 - 1]) {
                    dp[idx1][idx2] = dp[idx1 - 1][idx2 - 1] + 1
                } else {
                    dp[idx1][idx2] = maxOf(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1])
                }
            }
        }

        val common = dp[len1][len2]
        return (len1 - common) + (len2 - common)
    }
}