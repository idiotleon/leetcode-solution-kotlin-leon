/**
 * https://leetcode.com/problems/stone-game-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/stone-game-ii/discuss/345230/Python-DP-Solution
 */
package com.zea7ot.leetcode.lvl3.lc1140

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun stoneGameII(piles: IntArray): Int {
        val nPiles = piles.size
        val suffixSums = piles.copyOf()
        for (i in nPiles - 2 downTo 0) {
            suffixSums[i] += suffixSums[i + 1]
        }

        val memo = Array(nPiles) { Array<Int?>(nPiles) { null } }

        return dfs(0, 1, suffixSums, nPiles, memo)
    }

    private fun dfs(player: Int,
                    m: Int,
                    suffixSums: IntArray,
                    nPiles: Int,
                    memo: Array<Array<Int?>>): Int {
        if (player + 2 * m >= nPiles) return suffixSums[player]

        memo[player][m]?.let { return it }

        var max = 0

        for (i in 1..2 * m) {
            val take = suffixSums[player] - suffixSums[player + i]
            max = maxOf(max,
                    take + suffixSums[player + i] - dfs(player + i, maxOf(i, m), suffixSums, nPiles, memo))
        }

        memo[player][m] = max
        return max
    }
}