/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 *
 * Time Complexity:     O(`lenT` * `lenS`)
 * Space Complexity:    O(`lenT` * `lenS`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-window-subsequence/discuss/109362/Java-Super-Easy-DP-Solution-(O(mn))
 */
package com.idiotleon.leetcode.lvl4.lc0727

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

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

        var idxStart = 0
        var minLen = lenS + 1
        val lastRow = dp.last()
        for (idxS in 1..lenS) {
            if (lastRow[idxS] == 0) continue

            if (idxS - lastRow[idxS] + 1 < minLen) {
                idxStart = lastRow[idxS] - 1
                minLen = idxS - lastRow[idxS] + 1
            }
        }

        return if (minLen == lenS + 1) "" else S.substring(idxStart, idxStart + minLen)
    }
}