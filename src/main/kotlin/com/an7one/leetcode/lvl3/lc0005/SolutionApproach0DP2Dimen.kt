package com.an7one.leetcode.lvl3.lc0005

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * `dp[lo][hi]`, whether `str.substring(lo, hi + 1)` is a palindrome
 *
 * References:
 *  https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming/223961
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun longestPalindrome(str: String): String {
        val lenS = str.length
        if (lenS < 2) return str

        val dp = Array(lenS) { BooleanArray(lenS) { false } }

        var loAns = 0
        var hiAns = 0

        for (lo in lenS - 1 downTo 0) {
            for (hi in lo until lenS) {
                dp[lo][hi] = (str[lo] == str[hi]) && (hi - lo < 2 || dp[lo + 1][hi - 1])

                if (dp[lo][hi] && hi - lo + 1 > hiAns - loAns + 1) {
                    loAns = lo
                    hiAns = hi
                }
            }
        }

        return str.substring(loAns, hiAns + 1)
    }
}