/**
 * https://leetcode.com/problems/longest-repeating-substring/
 *
 * Time Complexity:     O(`lenS` ^ 2)
 * Space Complexity:    O(`lenS` ^ 2)
 *
 * `dp[lo][hi]`, number of repeated chars for substrings [`lo`, `hi - 1`)
 *
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/303884/easy-to-understand-N2-solution
 */
package com.zea7ot.leetcode.lvl4.lc1062

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun longestRepeatingSubstring(str: String): Int {
        val lenS = str.length
        val dp = Array(lenS + 1) { IntArray(lenS + 1) { 0 } }

        var longest = 0
        for (lo in 1..lenS) {
            for (hi in lo + 1..lenS) {
                if (str[lo - 1] == str[hi - 1]) {
                    dp[lo][hi] = dp[lo - 1][hi - 1] + 1
                    longest = maxOf(longest, dp[lo][hi])
                }
            }
        }

        return longest
    }
}