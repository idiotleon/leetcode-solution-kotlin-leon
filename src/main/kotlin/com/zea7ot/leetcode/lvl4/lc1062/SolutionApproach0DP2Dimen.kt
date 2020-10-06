/**
 * https://leetcode.com/problems/longest-repeating-substring/
 *
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O(L ^ 2)
 *
 * `dp[i][j]`, number of repeated chars for substrings ending at `i` and `j`
 *
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/303884/easy-to-understand-N2-solution
 */
package com.zea7ot.leetcode.lvl4.lc1062

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun longestRepeatingSubstring(str: String): Int {
        // sanity check
        if (str.isEmpty()) return 0

        val lenS = str.length
        var longest = 0

        val dp = Array(lenS + 1) { IntArray(lenS + 1) }
        for (i in 1 until lenS + 1) {
            for (j in i + 1 until lenS + 1) {
                if (str[i - 1] != str[j - 1]) continue
                dp[i][j] = dp[i - 1][j - 1] + 1
                longest = maxOf(longest, dp[i][j])
            }
        }

        return longest
    }
}