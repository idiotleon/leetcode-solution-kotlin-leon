/**
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Time Complexity:     O(`lenS` * `lenT`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java/35364
 */
package com.an7one.leetcode.lvl4.lc0115

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun numDistinct(s: String, t: String): Int {
        val lenS = s.length
        val lenT = t.length

        val dp = IntArray(lenS + 1) { 1 }

        for (idxT in 1..lenT) {
            var prev = dp[0]
            dp[0] = 0
            for (idxS in 1..lenS) {
                val temp = dp[idxS]

                dp[idxS] = if (s[idxS - 1] == t[idxT - 1]) {
                    dp[idxS - 1] + prev
                } else {
                    dp[idxS - 1]
                }

                prev = temp
            }
        }

        return dp[lenS]
    }
}