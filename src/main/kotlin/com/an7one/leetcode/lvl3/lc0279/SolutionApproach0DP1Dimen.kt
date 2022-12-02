package com.an7one.leetcode.lvl3.lc0279

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/perfect-squares/
 *
 * Time Complexity:     O(`n` * sqrt(`n`))
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java/73784
 * https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }.also {
            it[0] = 0
        }

        for (num in 1..n) {
            var factor = 1
            while (factor * factor <= num) {
                dp[num] = minOf(dp[num], 1 + dp[num - factor * factor])
                ++factor
            }
        }

        return dp[n]
    }
}