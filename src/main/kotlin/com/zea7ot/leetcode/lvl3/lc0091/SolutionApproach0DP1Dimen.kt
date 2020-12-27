/**
 * https://leetcode.com/problems/decode-ways/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation/330433
 */
package com.zea7ot.leetcode.lvl3.lc0091

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun numDecodings(str: String): Int {
        val lenS = str.length
        val dp = IntArray(lenS) { 0 }.also {
            it[0] = if (str[0] == '0') 0 else 1
        }

        for (idx in 1 until lenS) {
            val curDigit = str[idx] - '0'
            if (curDigit != 0) {
                dp[idx] += dp[idx - 1]
            }

            val prevDigit = (str[idx - 1] - '0') * 10 + curDigit
            if (prevDigit in 10..26) {
                dp[idx] += if (idx >= 2) dp[idx - 2] else 1
            }
        }

        return dp[lenS - 1]
    }
}