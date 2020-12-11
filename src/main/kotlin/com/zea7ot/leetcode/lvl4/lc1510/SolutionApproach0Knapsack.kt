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

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Knapsack {
    fun winnerSquareGame(n: Int): Boolean {
        val dp = BooleanArray(n + 1) { false }
        for (idx in 0..n) {
            if (dp[idx]) continue

            var remove = 1
            while (idx + remove * remove <= n) {
                dp[idx + remove * remove] = true

                ++remove
            }
        }

        return dp[n]
    }
}