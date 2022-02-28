package com.an7one.leetcode.lvl4.lc0139

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity:     O(L ^ 2) + O(totalWords)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun wordBreak(str: String, wordDict: List<String>): Boolean {
        // sanity check
        if (str.isEmpty()) return false

        val lenS = str.length
        val wordSet = wordDict.toHashSet()

        val dp = BooleanArray(lenS + 1) { idx -> idx == 0 }

        for (hi in 1..lenS) {
            for (lo in 0..hi) {
                if (dp[lo] && wordSet.contains(str.substring(lo, hi))) {
                    dp[hi] = true
                    // pruning here
                    break
                }
            }
        }

        return dp[lenS]
    }
}