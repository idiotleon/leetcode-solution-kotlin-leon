/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2`)
 *
 * References:
 *  https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)/106401
 */
package com.an7one.leetcode.lvl3.lc0583

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun minDistance(word1: String, word2: String): Int {
        val len1 = word1.length
        val len2 = word2.length

        val dp = Array(len1 + 1) { IntArray(len2 + 1) { 0 } }

        for (idx1 in word1.indices) {
            for (idx2 in word2.indices) {
                dp[idx1 + 1][idx2 + 1] = if (word1[idx1] == word2[idx2]) {
                    1 + dp[idx1][idx2]
                } else {
                    maxOf(dp[idx1][idx2 + 1], dp[idx1 + 1][idx2])
                }
            }
        }

        val longest = dp.last().last()

        return (len1 - longest) + (len2 - longest)
    }
}