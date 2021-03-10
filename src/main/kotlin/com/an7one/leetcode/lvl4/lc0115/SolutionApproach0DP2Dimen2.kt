/**
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Time Complexity:     O(`lenS` * `lenT`)
 * Space Complexity:    O(`lenS` * `lenT`)
 *
 *  initialization:
 *      when `t` is empty, `dp[0]` should be 1,
 *      because the empty string is a subsequence of any string but only for once
 *
 * References:
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP
 *  https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
 *  https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java/35364
 */
package com.an7one.leetcode.lvl4.lc0115

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen2 {
    fun numDistinct(s: String, t: String): Int {
        val lenS = s.length
        val lenT = t.length

        val dp = Array(lenS + 1) { IntArray(lenT + 1) { idxT -> if (idxT == 0) 1 else 0 } }

        for (idxS in s.indices) {
            for (idxT in t.indices) {
                dp[idxS + 1][idxT + 1] = if (s[idxS] == t[idxT]) {
                    dp[idxS][idxT] + dp[idxS][idxT + 1]
                } else {
                    dp[idxS][idxT + 1]
                }
            }
        }

        return dp[lenS][lenT]
    }
}