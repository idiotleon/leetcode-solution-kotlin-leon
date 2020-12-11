/**
 * https://leetcode.com/problems/new-21-game/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/new-21-game/discuss/132334/One-Pass-DP-O(N)
 */
package com.zea7ot.leetcode.lvl4.lc0837

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun new21Game(N: Int, K: Int, W: Int): Double {
        if (K == 0 || N >= K + W) return 1.0

        val dp = DoubleArray(N + 1) { idx -> if (idx == 0) 1.0 else 0.0 }

        var sumW = 1.0
        var ans = 0.0

        for (idx in 1..N) {
            dp[idx] = sumW / W
            if (idx < K) sumW += dp[idx] else ans += dp[idx]
            if (idx - W >= 0) sumW -= dp[idx - W]
        }

        return ans
    }
}