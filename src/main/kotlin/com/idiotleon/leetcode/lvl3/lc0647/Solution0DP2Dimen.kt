package com.idiotleon.leetcode.lvl3.lc0647

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * Reference:
 * https://leetcode.com/problems/palindromic-substrings/discuss/258917/Java-Simple-Code%3A-DP-short
 */
@Suppress(UNUSED)
class Solution0DP2Dimen {
    fun countSubstrings(str: String): Int {
        val lenS = str.length

        val dp = Array(lenS) { BooleanArray(lenS) { false } }

        var count = 0

        for (len in 0 until lenS) {
            for (lo in 0 until lenS - len) {
                val hi = lo + len

                if (str[lo] == str[hi]) {
                    dp[lo][hi] = if (hi - lo <= 2) true // if the `len` <= 3
                    else dp[lo + 1][hi - 1] // if the `len` > 3

                    if (dp[lo][hi]) {
                        ++count
                    }
                }
            }
        }

        return count
    }
}