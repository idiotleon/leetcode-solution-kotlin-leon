/**
 * https://leetcode.com/problems/word-break/
 *
 * Time Complexity:     O(L ^ 2) + O(totalWords)
 * Space Complexity:    O(L)
 *
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
 */
package com.zea7ot.leetcode.lvl4.lc0139

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // sanity check
        if (s.isEmpty()) return false

        val lenS = s.length
        val wordSet = HashSet(wordDict)

        val dp = BooleanArray(lenS + 1)
        dp[0] = true

        for (hi in 1..lenS) {
            for (lo in 0..hi) {
                if (dp[lo] && wordSet.contains(s.substring(lo, hi))) {
                    dp[hi] = true
                    break
                }
            }
        }

        return dp[lenS]
    }
}