/**
 * https://leetcode.com/problems/interleaving-string/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2`)
 *
 * References:
 *  https://leetcode.com/problems/interleaving-string/discuss/31879/My-DP-solution-in-C++/30687
 */
package com.zea7ot.leetcode.lvl4.lc0097

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        val len3 = s3.length
        if (len1 + len2 != len3) return false

        val dp = Array(len1 + 1) { BooleanArray(len2 + 1) { false } }

        for (idx1 in 0..len1) {
            for (idx2 in 0..len2) {
                dp[idx1][idx2] = when {
                    idx1 == 0 && idx2 == 0 -> true
                    idx1 == 0 -> dp[idx1][idx2 - 1] && s2[idx2 - 1] == s3[idx2 - 1]
                    idx2 == 0 -> dp[idx1 - 1][idx2] && s1[idx1 - 1] == s3[idx1 - 1]
                    else -> {
                        val idx3 = idx1 + idx2 - 1
                        (dp[idx1 - 1][idx2] && s1[idx1 - 1] == s3[idx3]) || (dp[idx1][idx2 - 1] && s2[idx2 - 1] == s3[idx3])
                    }
                }
            }
        }

        return dp[len1][len2]
    }
}