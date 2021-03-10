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
package com.an7one.leetcode.lvl4.lc1062

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun longestRepeatingSubstring(str: String): Int {
        val lenS = str.length

        val dp = Array(lenS + 1) { IntArray(lenS + 1) { 0 } }

        var longest = 0
        for (lo in str.indices) {
            for (hi in lo + 1 until lenS) {
                dp[lo + 1][hi + 1] = if (str[lo] == str[hi]) {
                    1 + dp[lo][hi]
                } else {
                    0 // this tells the difference between "substring" vs "subsequence"
                }

                longest = maxOf(longest, dp[lo + 1][hi + 1])
            }
        }

        return longest
    }
}