/**
 * https://leetcode.com/problems/stone-game-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/stone-game-ii/discuss/345230/Python-DP-Solution/637641
 *  https://leetcode.com/problems/stone-game-ii/discuss/345230/Python-DP-Solution
 */
package com.idiotleon.leetcode.lvl3.lc1140

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun stoneGameII(piles: IntArray): Int {
        val nPiles = piles.size
        val suffixSums = piles.copyOf()
        for (idx in nPiles - 2 downTo 0) {
            suffixSums[idx] += suffixSums[idx + 1]
        }

        val memo = Array(nPiles) { Array<Int?>(nPiles) { null } }

        return dfs(0, 1, suffixSums, nPiles, memo)
    }

    private fun dfs(curTake: Int, m: Int, suffixSums: IntArray, nPiles: Int, memo: Array<Array<Int?>>): Int {
        if (curTake + 2 * m >= nPiles) return suffixSums[curTake]

        memo[curTake][m]?.let { return it }

        var mostStones = 0
        for (moreTake in 1..2 * m) {
            mostStones = maxOf(
                mostStones,
                suffixSums[curTake] - dfs(curTake + moreTake, maxOf(moreTake, m), suffixSums, nPiles, memo)
            )
        }

        memo[curTake][m] = mostStones
        return mostStones
    }
}