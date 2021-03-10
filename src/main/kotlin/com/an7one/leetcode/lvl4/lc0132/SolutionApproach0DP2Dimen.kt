/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * Time Complexity:     O(`lenS` ^ `lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * `minCuts[hi]`, minimum of `1 + minCuts[lo - 1]` (lo <= hi), if substring[lo, hi] is palindrome
 * if substring[lo, hi] is palindrome, substring[lo + 1, hi - 1] is palindrome, and `minCuts[lo] == minCuts[hi]`
 *
 *
 *  a       b       a       |   c       c
 *                  j           i
 *                  j - 1   |   [j  i] is palindrome
 *             cut(j - 1)   +   1
 *
 *
 * References:
 *  https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42213/Easiest-Java-DP-Solution-(97.36)/115333
 *  https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42213/Easiest-Java-DP-Solution-(97.36)
 */
package com.an7one.leetcode.lvl4.lc0132

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minCut(str: String): Int {
        val lenS = str.length
        val dp = Array(lenS + 1) { BooleanArray(lenS + 1) { false } }
        val minCuts = IntArray(lenS) { 0 }

        for (hi in str.indices) {
            minCuts[hi] = hi
            for (lo in 0..hi) {
                if (str[lo] == str[hi] && (lo + 1 > hi - 1 || dp[lo + 1][hi - 1])) {
                    dp[lo][hi] = true

                    minCuts[hi] = if (lo == 0) 0 else minOf(minCuts[hi], 1 + minCuts[lo - 1])
                }
            }
        }

        return minCuts[lenS - 1]
    }
}