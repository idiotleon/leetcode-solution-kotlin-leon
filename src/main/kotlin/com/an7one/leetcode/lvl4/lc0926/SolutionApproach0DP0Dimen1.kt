/**
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-926-flip-string-to-monotone-increasing/
 */
package com.an7one.leetcode.lvl4.lc0926

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen1 {
    fun minFlipsMonoIncr(str: String): Int {
        val lenS = str.length

        var dp0 = 0
        var dp1 = 0

        for (idx in 1..lenS) {
            val temp = dp0 + if (str[idx - 1] == '1') 1 else 0
            dp1 = minOf(dp0, dp1) + if (str[idx - 1] == '0') 1 else 0
            dp0 = temp
        }

        return minOf(dp0, dp1)
    }
}