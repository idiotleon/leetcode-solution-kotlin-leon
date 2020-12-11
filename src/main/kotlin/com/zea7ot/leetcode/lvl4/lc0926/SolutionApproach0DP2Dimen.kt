/**
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-926-flip-string-to-monotone-increasing/
 */
package com.zea7ot.leetcode.lvl4.lc0926

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minFlipsMonoIncr(str: String): Int {
        val lenS = str.length

        val dp = Array(lenS + 1) { IntArray(2) { 0 } }
        for (idx in 1..lenS) {
            if (str[idx - 1] == '0') {
                dp[idx][0] = dp[idx - 1][0]
                dp[idx][1] = minOf(dp[idx - 1][0], dp[idx - 1][1]) + 1
            } else {
                dp[idx][0] = dp[idx - 1][0] + 1
                dp[idx][1] = minOf(dp[idx - 1][0], dp[idx - 1][1])
            }
        }

        return minOf(dp[lenS][0], dp[lenS][1])
    }
}