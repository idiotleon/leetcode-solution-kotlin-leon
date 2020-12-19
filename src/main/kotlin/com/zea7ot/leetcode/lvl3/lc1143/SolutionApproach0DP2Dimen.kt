/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2`)
 *
 * References:
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 */
package com.zea7ot.leetcode.lvl3.lc1143

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val len1 = text1.length
        val len2 = text2.length

        val dp = Array(len1 + 1) { IntArray(len2 + 1) { 0 } }

        for (idx1 in text1.indices) {
            for (idx2 in text2.indices) {
                dp[idx1 + 1][idx2 + 1] = if (text1[idx1] == text2[idx2]) {
                    1 + dp[idx1][idx2]
                } else {
                    maxOf(dp[idx1][idx2 + 1], dp[idx1 + 1][idx2])
                }
            }
        }

        return dp[len1][len2]
    }
}