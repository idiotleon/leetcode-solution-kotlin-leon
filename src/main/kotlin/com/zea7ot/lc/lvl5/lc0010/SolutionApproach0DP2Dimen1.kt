/**
 * @author: Leon
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * Time Complexity:     O(LEN_S * LEN_P)
 * Space Complexity:    O(LEN_S * LEN_P)
 *
 * References:
 *  https://www.youtube.com/watch?v=l3hda49XcDE&t=389s
 */
package com.zea7ot.lc.lvl5.lc0010

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    private companion object {
        private const val PLACE_HOLDER_MULTIPLE = '*'
        private const val PLACE_HOLDER_SINGLE = '.'
    }

    fun isMatch(s: String, p: String): Boolean {
        val lenS = s.length
        val lenP = p.length

        val dp = Array(lenS + 1) { BooleanArray(lenP + 1) { false } }
        dp[0][0] = true

        for (idxP in 1..lenP) {
            if (p[idxP - 1] == PLACE_HOLDER_MULTIPLE) {
                dp[0][idxP] = dp[0][idxP - 2]
            }
        }

        for (idxS in 1..lenS) {
            for (idxP in 1..lenP) {
                if (p[idxP - 1] == PLACE_HOLDER_SINGLE || p[idxP - 1] == s[idxS - 1]) {
                    dp[idxS][idxP] = dp[idxS - 1][idxP - 1]
                } else if (p[idxP - 1] == PLACE_HOLDER_MULTIPLE) {
                    dp[idxS][idxP] = dp[idxS][idxP - 2]

                    if (p[idxP - 2] == PLACE_HOLDER_SINGLE || p[idxP - 2] == s[idxS - 1]) {
                        dp[idxS][idxP] = dp[idxS][idxP] || dp[idxS - 1][idxP]
                    }
                } else {
                    dp[idxS][idxP] = false
                }
            }
        }

        return dp[lenS][lenP]
    }
}