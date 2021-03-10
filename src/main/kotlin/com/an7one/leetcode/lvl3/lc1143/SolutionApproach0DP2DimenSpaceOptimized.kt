/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(2 * `len2`) ~ O(`len2`)
 *
 * References:
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 */
package com.an7one.leetcode.lvl3.lc1143

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2DimenSpaceOptimized {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val len1 = text1.length
        val len2 = text2.length

        val dp = Array(2) { IntArray(len2 + 1) { 0 } }

        for (idx1 in 1..len1) {
            for (idx2 in 1..len2) {
                dp[idx1 % 2][idx2] = if (text1[idx1 - 1] == text2[idx2 - 1]) {
                    dp[(idx1 - 1) % 2][idx2 - 1] + 1
                } else {
                    maxOf(dp[(idx1 - 1) % 2][idx2], dp[idx1 % 2][idx2 - 1])
                }
            }
        }

        return dp[len1 % 2][len2]
    }
}