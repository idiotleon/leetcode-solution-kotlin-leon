/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len2`)
 *
 * References:
 *  https://leetcode.com/problems/delete-operation-for-two-strings/discuss/103214/Java-DP-Solution-(Longest-Common-Subsequence)/106397
 */
package com.an7one.leetcode.lvl3.lc0583

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minDistance(word1: String, word2: String): Int {
        val len1 = word1.length
        val len2 = word2.length

        val dp = IntArray(len2 + 1) { 0 }
        for (idx1 in 0 until len1) {
            var prev = 0
            for (idx2 in 0 until len2) {
                val temp = dp[idx2 + 1]
                dp[idx2 + 1] = maxOf(dp[idx2 + 1], dp[idx2])
                if (word1[idx1] == word2[idx2]) {
                    dp[idx2 + 1] = maxOf(dp[idx2 + 1], prev + 1)
                }

                prev = temp
            }
        }

        val common = dp[len2]
        return (len1 - common) + (len2 - common)
    }
}