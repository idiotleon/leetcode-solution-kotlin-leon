package com.idiotleon.leetcode.lvl4.lc0115

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Time Complexity:     O(`lenS` * `lenT`)
 * Space Complexity:    O(`lenS` * `lenT`)
 *
 *  initialization:
 *      when `t` is empty, `dp[0]` should be 1,
 *      because the empty string is a subsequence of any string but only for once
 *
 * Reference:
 * https://leetcode.com/problems/distinct-subsequences/discuss/37413/Concise-JAVA-solution-based-on-DP
 * https://leetcode.wang/leetcode-115-Distinct-Subsequences.html
 * https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
 * https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java/35364
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun numDistinct(s: String, t: String): Int {
        val lenS = s.length
        val lenT = t.length

        val dp = Array(lenS + 1) { IntArray(lenT + 1) { idxT -> if (idxT == 0) 1 else 0 } }

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