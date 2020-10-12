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
class SolutionApproach0DP2Dimen {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        val len3 = s3.length
        if (len1 + len2 != len3) return false

        val dp = Array(len1 + 1) { BooleanArray(len2 + 1) { false } }
        dp[0][0] = true
        for (idx1 in 1..len1) {
            dp[idx1][0] = dp[idx1 - 1][0] && s1[idx1 - 1] == s3[idx1 - 1]
        }

        for (idx2 in 1..len2) {
            dp[0][idx2] = dp[0][idx2 - 1] && s2[idx2 - 1] == s3[idx2 - 1]
        }

        for (idx1 in 1..len1) {
            for (idx2 in 1..len2) {
                val idx3 = idx1 + idx2 - 1
                dp[idx1][idx2] = (dp[idx1 - 1][idx2] && s1[idx1 - 1] == s3[idx3]) || (dp[idx1][idx2 - 1] && s2[idx2 - 1] == s3[idx3])
            }
        }

        return dp[len1][len2]
    }
}