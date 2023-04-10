package com.idiotleon.leetcode.lvl6.lc0087

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/scramble-string/
 *
 * Time Complexity:     O(`len1` ^ 4)
 * Space Complexity:    O(`len1` ^ 3)
 *
 * Reference:
 * https://leetcode.com/problems/scramble-string/discuss/29396/Simple-iterative-DP-Java-solution-with-explanation
 */
@Suppress(UNUSED)
class SolutionApproach0DP3Dimen {
    fun isScramble(s1: String, s2: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        if (len1 != len2) return false

        val dp = Array(len1) { Array(len2) { BooleanArray(len1 + 1) { false } } }

        for (len in 1..len1) {
            for (idx1 in 0..len1 - len) {
                for (idx2 in 0..len2 - len) {
                    if (len == 1) {
                        dp[idx1][idx2][len] = s1[idx1] == s2[idx2]
                    } else {
                        for (delta in 1 until len) {
                            if (dp[idx1][idx2][len]) break
                            dp[idx1][idx2][len] =
                                (dp[idx1][idx2][delta] && dp[idx1 + delta][idx2 + delta][len - delta] || dp[idx1][idx2 + len - delta][delta] && dp[idx1 + delta][idx2][len - delta])
                        }
                    }
                }
            }
        }

        return dp[0][0][len1]
    }
}