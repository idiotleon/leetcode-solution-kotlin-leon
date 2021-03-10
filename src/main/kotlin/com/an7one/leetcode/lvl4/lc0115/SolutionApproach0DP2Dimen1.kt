/**
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Time Complexity:     O(`lenS` * `lenT`)
 * Space Complexity:    O(`lenS` * `lenT`)
 *
 * References:
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP
 *  https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 */
package com.an7one.leetcode.lvl4.lc0115

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun numDistinct(s: String, t: String): Int {
        val lenS = s.length
        val lenT = t.length

        val dp = Array(lenS + 1) { IntArray(lenT + 1) { 0 } }
        for (idxS in 0..lenS) {
            dp[idxS][0] = 1
        }

        for (idxS in 1..lenS) {
            for (idxT in 1..lenT) {
                dp[idxS][idxT] = if (s[idxS - 1] == t[idxT - 1]) {
                    dp[idxS - 1][idxT] + dp[idxS - 1][idxT - 1]
                } else {
                    dp[idxS - 1][idxT]
                }
            }
        }

        return dp[lenS][lenT]
    }
}