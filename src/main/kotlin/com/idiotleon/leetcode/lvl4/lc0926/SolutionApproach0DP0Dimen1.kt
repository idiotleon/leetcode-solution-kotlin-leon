package com.idiotleon.leetcode.lvl4.lc0926

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-926-flip-string-to-monotone-increasing/
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen1 {
    private companion object {
        private const val ONE: Char = '1';
        private const val ZERO: Char = '0';
    }

    fun minFlipsMonoIncr(str: String): Int {
        val lenS = str.length

        var dp0 = 0
        var dp1 = 0

        for (idx in 1..lenS) {
            val temp = dp0 + if (str[idx - 1] == ONE) 1 else 0
            dp1 = minOf(dp0, dp1) + if (str[idx - 1] == ZERO) 1 else 0
            dp0 = temp
        }

        return minOf(dp0, dp1)
    }
}