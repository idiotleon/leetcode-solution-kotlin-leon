/**
 * https://leetcode.com/problems/valid-palindrome-iii/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/valid-palindrome-iii/discuss/397606/Find-Longest-Palindromic-Subsequence./358118
 */
package com.zea7ot.leetcode.lvl4.lc1216

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun isValidPalindrome(s: String, k: Int): Boolean {
        val lenS = s.length
        val dp = Array(lenS) { idx1 -> Array(lenS) { idx2 -> if (idx1 == idx2) 1 else 0 } }

        for (lo in lenS - 1 downTo 0) {
            for (hi in lo + 1 until lenS) {
                dp[lo][hi] = if (s[lo] == s[hi]) {
                    dp[lo + 1][hi - 1] + 2
                } else {
                    maxOf(dp[lo + 1][hi], dp[lo][hi - 1])
                }
            }
        }

        // the length of the longest common subsequence
        val longest = dp[0][lenS - 1]
        return lenS - longest <= k
    }
}