/**
 * https://leetcode.com/problems/longest-repeating-substring/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/318629/DP-solution-O(n2)-time-O(n)-space
 */
package com.an7one.leetcode.lvl4.lc1062

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun longestRepeatingSubstring(str: String): Int {
        val lenS = str.length
        var longest = 0
        val dp = IntArray(lenS + 1) { 0 }

        for (hi in 1..lenS) {
            for (lo in hi - 1 downTo 1) {
                dp[lo] = if (str[lo - 1] == str[hi - 1]) {
                    dp[lo - 1] + 1
                } else {
                    0
                }

                longest = maxOf(longest, dp[lo])
            }
        }

        return longest
    }
}