package com.an7one.leetcode.lvl3.lc0877

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/stone-game/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://youtu.be/WxpIHvsu1RI
 * https://leetcode.com/problems/stone-game/discuss/154610/DP-or-Just-return-true
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun stoneGame(piles: IntArray): Boolean {
        val nPiles = piles.size

        val dp = piles.copyOf()
        for (player1 in 1 until nPiles) {
            for (player2 in 0 until nPiles - player1) {
                dp[player2] = maxOf(
                    piles[player2] - dp[player2 + 1], piles[player1 + player2] - dp[player2]
                )
            }
        }

        return dp[0] > 0
    }
}