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
        val totalPiles = piles.size
        val suffixSums = piles.copyOf()
        for (i in totalPiles - 2 downTo 0) {
            suffixSums[i] += suffixSums[i + 1]
        }

        val memo = Array(totalPiles) { Array<Int?>(totalPiles) { null } }

        return dfs(0, 1, suffixSums, totalPiles, memo)
    }

    private fun dfs(player: Int,
                    m: Int,
                    prefixSums: IntArray,
                    totalPiles: Int,
                    memo: Array<Array<Int?>>): Int {
        if (player + 2 * m >= totalPiles) return prefixSums[player]

        memo[player][m]?.let { return it }

        var max = 0
        var take = 0

        for (i in 1..2 * m) {
            take = prefixSums[player] - prefixSums[player + i]
            max = maxOf(max,
                    take + prefixSums[player + i] - dfs(player + i, maxOf(i, m), prefixSums, totalPiles, memo))
        }
        memo[player][m] = max
        return max
    }
}