/**
 * https://leetcode.com/problems/stone-game-ii/
 *
 * Time Complexity:     O(`totalPiles` ^ 2)
 * Space Complexity:    O(`totalPiles`)
 *
 * `dp[i][m]`, the maximal number of stones a player can get when [0, i) piles have been taken, and the current `M` is `m`
 *
 * References:
 *  https://leetcode.com/problems/stone-game-ii/discuss/355710/Java-simple-DP-solution-with-explanation
 */
package com.zea7ot.leetcode.lvl3.lc1140

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun stoneGameII(piles: IntArray): Int {
        val nPiles = piles.size
        if (nPiles <= 2) return piles[0]

        val suffixSums = piles.copyOf()
        for (i in nPiles - 2 downTo 0) {
            suffixSums[i] += suffixSums[i + 1]
        }

        val dp = Array(nPiles) { IntArray((nPiles + 1) / 2 + 1) { 0 } }

        for (i in nPiles - 1 downTo 0) {
            val sum = suffixSums[i]
            var m = (nPiles - i + 1) / 2
            dp[i][m] = sum
            while (--m > 0) {
                dp[i][m] = 0
                for (x in 1..m * 2) {
                    if (x + i >= nPiles) break
                    val max = minOf((nPiles - i - x + 1) / 2, maxOf(x, m))
                    dp[i][m] = maxOf(dp[i][m], sum - dp[i + x][max])
                }
            }
        }

        return dp[0][1]
    }
}