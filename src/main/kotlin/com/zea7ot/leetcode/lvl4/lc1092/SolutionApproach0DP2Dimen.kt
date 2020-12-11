/**
 * https://leetcode.com/problems/shortest-common-supersequence/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2` * L)
 *  L, the length of Longest Common Subsequence
 *
 * a bottom-up approach
 *
 * References:
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/312710/C++Python-Find-the-LCS/434150
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/312710/C++Python-Find-the-LCS/290904
 */
package com.zea7ot.leetcode.lvl4.lc1092

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val len1 = str1.length
        val len2 = str2.length

        val common = longestCommonSubsequence(str1, str2)
        var idx1 = 0
        var idx2 = 0
        val builder = StringBuilder()

        for (ch in common) {
            while (idx1 < len1 && str1[idx1] != ch) {
                builder.append(str1[idx1++])
            }

            while (idx2 < len2 && str2[idx2] != ch) {
                builder.append(str2[idx2++])
            }

            builder.append(ch)
            ++idx1
            ++idx2
        }

        builder.append(str1.substring(idx1)).append(str2.substring(idx2))
        return builder.toString()
    }

    private fun longestCommonSubsequence(str1: String, str2: String): String {
        val len1 = str1.length
        val len2 = str2.length
        val dp = Array(len1 + 1) { Array(len2 + 1) { "" } }

        for (idx1 in 1..len1) {
            for (idx2 in 1..len2) {
                dp[idx1][idx2] = when {
                    str1[idx1 - 1] == str2[idx2 - 1] -> dp[idx1 - 1][idx2 - 1] + str1[idx1 - 1]
                    dp[idx1 - 1][idx2].length > dp[idx1][idx2 - 1].length -> dp[idx1 - 1][idx2]
                    else -> dp[idx1][idx2 - 1]
                }

                // or equivalently
//                dp[idx1][idx2] = if (str1[idx1 - 1] == str2[idx2 - 1]) {
//                    dp[idx1 - 1][idx2 - 1] + str1[idx1 - 1]
//                } else {
//                    if (dp[idx1 - 1][idx2].length > dp[idx1][idx2 - 1].length) {
//                        dp[idx1 - 1][idx2]
//                    } else {
//                        dp[idx1][idx2 - 1]
//                    }
//                }
            }
        }

        return dp[len1][len2]
    }
}