package com.an7one.leetcode.lvl4.lc1510

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/stone-game-iv/
 *
 * Time Complexity:     O(`n` ^ 1.5)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://leetcode.com/problems/stone-game-iv/discuss/730582/JavaC%2B%2BPython-DP
 */
@Suppress(UNUSED)
class SolutionApproach0Knapsack1 {
    fun winnerSquareGame(n: Int): Boolean {
        val dp = BooleanArray(n + 1) { false }
        for (hi in 1..n) {
            var lo = 1
            while (lo * lo <= hi) {
                if (!dp[hi - lo * lo]) {
                    dp[hi] = true
                    break
                }

                ++lo
            }
        }

        return dp[n]
    }
}