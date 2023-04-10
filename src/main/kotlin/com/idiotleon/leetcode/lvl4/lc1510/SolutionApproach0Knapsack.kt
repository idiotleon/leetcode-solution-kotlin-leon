package com.idiotleon.leetcode.lvl4.lc1510

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/stone-game-iv/
 *
 * Time Complexity:     O(`n` ^ 1.5)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://leetcode.com/problems/stone-game-iv/discuss/730582/JavaC++Python-DP/619672
 * https://leetcode.com/problems/stone-game-iv/discuss/730582/JavaC%2B%2BPython-DP
 */
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