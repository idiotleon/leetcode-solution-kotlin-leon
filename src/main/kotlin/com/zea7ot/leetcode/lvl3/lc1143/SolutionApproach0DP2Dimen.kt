/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Time Complexity:     O(`len1` * `len2`)
 * Space Complexity:    O(`len1` * `len2`)
 *
 * References:
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 */
package com.zea7ot.leetcode.lvl3.lc1143

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun isValidPalindrome(s: String, k: Int): Boolean {
        val lenS = s.length
        val t = StringBuilder(s).reverse().toString()
        val longest = longestCommonSubsequence(s, t)
        return lenS - longest <= k
    }

    private fun longestCommonSubsequence(s: String, t: String): Int {
        val lenS = s.length
        val lenT = t.length

        val dp = Array(lenS + 1) { Array(lenT + 1) { 0 } }
        for (idxS in 1..lenS) {
            for (idxT in 1..lenT) {
                dp[idxS][idxT] = if (s[idxS - 1] == t[idxT - 1]) {
                    dp[idxS - 1][idxT - 1] + 1
                } else {
                    maxOf(dp[idxS][idxT - 1], dp[idxS - 1][idxT])
                }
            }
        }

        return dp[lenS][lenT]
    }
}