/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * Time Complexity:     O(`lenS` ^ 2) + O(`lenS`)
 * Space Complexity:    O(`lenS` ^ 2)
 */
package com.idiotleon.leetcode.lvl4.lc1312

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minInsertions(s: String): Int {
        val lenS = s.length
        val t = s.reversed()

        val dp = Array(lenS + 1) { IntArray(lenS + 1) { 0 } }

        for (idxS in s.indices) {
            for (idxT in t.indices) {
                dp[idxS + 1][idxT + 1] = if (s[idxS] == t[idxT]) {
                    1 + dp[idxS][idxT]
                } else {
                    maxOf(dp[idxS][idxT + 1], dp[idxS + 1][idxT])
                }
            }
        }

        val longest = dp[lenS][lenS]
        return lenS - longest
    }
}