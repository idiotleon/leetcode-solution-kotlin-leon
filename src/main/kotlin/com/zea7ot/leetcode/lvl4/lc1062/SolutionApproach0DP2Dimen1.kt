/**
 * https://leetcode.com/problems/longest-repeating-substring/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * `dp[lo][hi]`, number of repeated chars for substrings [`lo`, `hi - 1`)
 *
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/303884/easy-to-understand-N2-solution
 */
package com.zea7ot.leetcode.lvl4.lc1062

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun longestRepeatingSubstring(str: String): Int {
        val lenS = str.length

        val dp = Array(lenS + 1) { IntArray(lenS + 1) { 0 } }

        var longest = 0
        for (lo in str.indices) {
            for (hi in lo + 1 until lenS) {
                if (str[lo] == str[hi]) {
                    dp[lo + 1][hi + 1] = 1 + dp[lo][hi]
                    longest = maxOf(longest, dp[lo + 1][hi + 1])
                }
            }
        }

        return longest
    }
}