/**
 * https://leetcode.com/problems/stone-game-iv/
 *
 * Time Complexity:     O(`n` ^ 1.5)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/stone-game-iv/discuss/730582/JavaC++Python-DP/619672
 *  https://leetcode.com/problems/stone-game-iv/discuss/730582/JavaC%2B%2BPython-DP
 */
package com.zea7ot.leetcode.lvl4.lc1510

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Knapsack {
    fun winnerSquareGame(n: Int): Boolean {
        val dp = BooleanArray(n + 1) { false }
        for (lo in 0..n) {
            if (dp[lo]) continue

            var hi = 1
            while (lo + hi * hi <= n) {
                dp[lo + hi * hi] = true

                ++hi
            }
        }

        return dp[n]
    }
}