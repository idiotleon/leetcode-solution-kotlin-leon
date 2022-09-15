package com.an7one.leetcode.lvl4.lc0656

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/coin-path/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/coin-path/discuss/130812/Java-Clear-Code-Beats-99.43-with-Explanations
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun cheapestJump(coins: IntArray, maxJump: Int): List<Int> {
        if (coins.isEmpty() || coins.last() == -1) return listOf()

        val nCoins = coins.size

        val memo = Array<Int?>(nCoins) { null }
        val paths = Array(nCoins) { -1 }

        dfs(0, coins, maxJump, paths, memo)

        val ans = mutableListOf<Int>()

        var k = 0
        while (k != -1) {
            ans.add(k + 1)
            k = paths[k]
        }

        if (ans.contains(nCoins)) return ans

        return listOf()
    }

    private fun dfs(
        idxStart: Int, coins: IntArray, maxJump: Int, paths: Array<Int>, memo: Array<Int?>
    ): Int {
        memo[idxStart]?.let { return it }

        val nCoins = coins.size
        if (idxStart == nCoins - 1) return 0

        var minCostGain = Int.MAX_VALUE
        var idxMin = -1
        for (jump in 1..maxJump) {
            val idxJump = idxStart + jump
            if (idxJump < nCoins && coins[idxJump] != -1) {
                val curCostGain = dfs(idxJump, coins, maxJump, paths, memo)

                if (curCostGain < minCostGain) {
                    minCostGain = curCostGain
                    idxMin = idxJump
                }
            }
        }

        paths[idxStart] = idxMin
        val minCost = coins[idxStart] + minCostGain
        memo[idxStart] = minCost
        return minCost
    }
}