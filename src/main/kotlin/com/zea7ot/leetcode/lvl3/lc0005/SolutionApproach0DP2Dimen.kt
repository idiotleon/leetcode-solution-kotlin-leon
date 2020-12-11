/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 *
 * `dp[i][j]`, whether `str.substring(i, j)` is a palindrome
 *
 *
 * References:
 *  https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming/223961
 */
package com.zea7ot.leetcode.lvl3.lc0005

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun longestPalindrome(s: String): String {
        val lenS = s.length
        // sanity check
        if (lenS < 2) return s

        val dp = Array(lenS) { BooleanArray(lenS) }

        var start = 0
        var end = 0

        for (i in lenS - 1 downTo 0) {
            for (j in i until lenS) {
                dp[i][j] = (s[i] == s[j]) && (j - i < 2 || dp[i + 1][j - 1])

                if (dp[i][j] && j - i > end - start) {
                    start = i
                    end = j
                }
            }
        }

        return s.substring(start, end + 1)
    }
}