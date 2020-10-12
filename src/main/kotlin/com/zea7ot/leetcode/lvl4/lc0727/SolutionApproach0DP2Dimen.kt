/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 *
 * Time Complexity:     O(`lenT` * `lenS`)
 * Space Complexity:    O(`lenT` * `lenS`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-window-subsequence/discuss/109362/Java-Super-Easy-DP-Solution-(O(mn))
 */
package com.zea7ot.leetcode.lvl4.lc0727

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minWindow(S: String, T: String): String {
        val lenS = S.length
        val lenT = T.length

        val dp = Array(lenT + 1) { idxT -> IntArray(lenS + 1) { idxS -> if (idxT == 0) idxS + 1 else 0 } }

        for (idxT in 1..lenT) {
            for (idxS in 1..lenS) {
                dp[idxT][idxS] = if (T[idxT - 1] == S[idxS - 1]) {
                    dp[idxT - 1][idxS - 1]
                } else {
                    dp[idxT][idxS - 1]
                }
            }
        }

        var startIdx = 0
        var len = lenS + 1
        for (idxS in 1..lenS) {
            if (dp[lenT][idxS] == 0) continue

            if (idxS - dp[lenT][idxS] + 1 < len) {
                startIdx = dp[lenT][idxS] - 1
                len = idxS - dp[lenT][idxS] + 1
            }
        }

        return if (len == lenS + 1) "" else S.substring(startIdx, startIdx + len)
    }
}