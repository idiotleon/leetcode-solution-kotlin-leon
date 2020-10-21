/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1)
 *
 * 3 passes
 *
 * References:
 *  https://leetcode.com/problems/shortest-distance-to-a-character/discuss/125788/C%2B%2BJavaPython-2-Pass-with-Explanation
 */
package com.zea7ot.leetcode.lvl2.lc0821

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun shortestToChar(str: String, ch: Char): IntArray {
        val lenS = str.length

        val dp = IntArray(lenS)

        for (idx in 0 until lenS) {
            dp[idx] = if (str[idx] == ch) 0 else lenS
        }

        for (idx in 1 until lenS) {
            dp[idx] = minOf(dp[idx], 1 + dp[idx - 1])
        }

        for (idx in lenS - 2 downTo 0) {
            dp[idx] = minOf(dp[idx], 1 + dp[idx + 1])
        }

        return dp
    }
}