/**
 * https://leetcode.com/problems/stone-game/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://youtu.be/WxpIHvsu1RI
 *  https://leetcode.com/problems/stone-game/discuss/154610/DP-or-Just-return-true
 */
package com.an7one.leetcode.lvl3.lc0877

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun stoneGame(piles: IntArray): Boolean {
        val totalPiles = piles.size

        val dp = piles.copyOf()
        for (player1 in 1 until totalPiles) {
            for (player2 in 0 until totalPiles - player1) {
                dp[player2] = maxOf(
                    piles[player2] - dp[player2 + 1],
                    piles[player1 + player2] - dp[player2]
                )
            }
        }

        return dp[0] > 0
    }
}