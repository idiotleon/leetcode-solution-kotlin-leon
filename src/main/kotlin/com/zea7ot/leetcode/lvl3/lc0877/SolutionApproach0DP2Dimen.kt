/**
 * https://leetcode.com/problems/stone-game/
 *
 * Time Complexity:     O(`nPiles` ^ 2)
 * Space Complexity:    O(`nPiles` ^ 2)
 *
 * dp[lo][hi], the most stones one can get that is more than what the opponent can pick in `piles[lo] ~ piles[hi]`
 *  if one picks `piles[lo]`, the result is `piles[lo] - dp[lo + 1][hi]`
 *  if one picks `piles[hi]`, the result is `piles[hi] - dp[lo][hi - 1]`
 *
 * so the final answer is:
 *  dp[lo][hi] = maxOf(piles[lo] - dp[lo + 1][hi], piles[hi] - dp[lo][hi - 1])
 *
 * References:
 *  https://youtu.be/WxpIHvsu1RI
 *  https://leetcode.com/problems/stone-game/discuss/154610/DP-or-Just-return-true
 */
package com.zea7ot.leetcode.lvl3.lc0877

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun stoneGame(piles: IntArray): Boolean {
        val nPiles = piles.size

        val dp = Array(nPiles) { IntArray(nPiles) { 0 } }.also {
            for (idx in piles.indices) {
                it[idx][idx] = piles[idx]
            }
        }

        for (len in 1 until nPiles) {
            for (lo in 0 until nPiles - len) {
                val hi = lo + len

                dp[lo][hi] = maxOf(
                    piles[lo] - dp[lo + 1][hi],
                    piles[hi] - dp[lo][hi - 1]
                )
            }
        }

        return dp[0][nPiles - 1] > 0
    }
}