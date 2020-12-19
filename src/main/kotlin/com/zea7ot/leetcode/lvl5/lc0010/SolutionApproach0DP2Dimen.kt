/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * Time Complexity:     O(lenS * lenP)
 * Space Complexity:    O(lenS * lenP)
 *
 * case 1:
 *  if p[idxP] == s[idxS]: dp[idxS][idxP] = dp[idxS - 1][idxP - 1];
 *
 * case 2:
 *  if p[idxP] == '.': dp[idxS][idxP] = dp[idxS - 1][idxP - 1];
 *
 * case 3:
 *  if p[idxP] == '*':
 *  3.1 if p[idxP - 1] != s[idxS]: dp[idxS][idxP] = dp[idxS][idxP - 2]  //in this case, a* only counts as empty
 *  3.2 if p[idxP - 1] == s[idxS] or p[idxS - 1] == '.':
 *         dp[idxS][idxP] = dp[idxS - 1][idxP]      // in this case, "a*" counts as multiple a
 *      or dp[idxS][idxP] = dp[idxS][idxP - 1]      // in this case, "a*" counts as single a
 *      or dp[idxS][idxP] = dp[idxS][idxP - 2]      // in this case, "a*" counts as empty
 *
 * References:
 *  https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
 */
package com.zea7ot.leetcode.lvl5.lc0010

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val PLACE_HOLDER_MULTIPLE = '*'
        private const val PLACE_HOLDER_SINGLE = '.'
    }

    fun isMatch(s: String, p: String): Boolean {
        val lenS = s.length
        val lenP = p.length

        val dp = Array(lenS + 1) { BooleanArray(lenP + 1) { false } }
        dp[0][0] = true

        for (idxP in 0 until lenP) {
            if (p[idxP] == PLACE_HOLDER_MULTIPLE && dp[0][idxP - 1]) {
                dp[0][idxP + 1] = true
            }
        }

        for (idxS in 0 until lenS) {
            for (idxP in 0 until lenP) {
                if (p[idxP] == PLACE_HOLDER_SINGLE) {
                    dp[idxS + 1][idxP + 1] = dp[idxS][idxP]
                }

                if (p[idxP] == s[idxS]) {
                    dp[idxS + 1][idxP + 1] = dp[idxS][idxP]
                }

                if (p[idxP] == PLACE_HOLDER_MULTIPLE) {
                    if (p[idxP - 1] != s[idxS] && p[idxP - 1] != PLACE_HOLDER_SINGLE) {
                        dp[idxS + 1][idxP + 1] = dp[idxS + 1][idxP - 1]
                    } else {
                        dp[idxS + 1][idxP + 1] = (dp[idxS + 1][idxP] || dp[idxS][idxP + 1] || dp[idxS + 1][idxP - 1])
                    }
                }
            }
        }

        return dp[lenS][lenP]
    }
}