/**
 * https://leetcode.com/problems/paint-house-iii/
 *
 * Time Complexity:     O(`m` * (`n` ^ 2))
 * Space Complexity:    O(`m` * `target` * `n`)
 *
 * References:
 *  https://leetcode.com/problems/paint-house-iii/discuss/674413/C++-Top-Down-DP/569880
 *  https://leetcode.com/problems/paint-house-iii/discuss/674413/C%2B%2B-Top-Down-DP
 */
package com.zea7ot.leetcode.lvl4.lc1473

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val RANGE = 1e6.toInt() + 1
    }

    fun minCost(houses: IntArray, costs: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        val memo = Array(m + 1) { Array(target + 1) { Array<Int?>(n + 1) { null } } }

        val minCost = dfs(0, 0, target, houses, costs, memo)
        return if (minCost == RANGE) -1 else minCost
    }

    private fun dfs(
        idxHouse: Int,
        idxPrevColor: Int,
        target: Int,
        houses: IntArray,
        costs: Array<IntArray>,
        memo: Array<Array<Array<Int?>>>
    ): Int {
        val nHouses = houses.size
        if (idxHouse >= nHouses || target < 0) return if (target == 0) target else RANGE
        val nColors = costs[idxHouse].size
        memo[idxHouse][target][idxPrevColor]?.let { return it }

        // painted last year
        if (houses[idxHouse] != 0) {
            return dfs(
                idxHouse + 1,
                houses[idxHouse],
                target - if (idxPrevColor == houses[idxHouse]) 0 else 1,
                houses,
                costs,
                memo
            )
        }

        var minCost = RANGE
        for (idxCurColor in 1..nColors) {
            val curCost = costs[idxHouse][idxCurColor - 1] + dfs(
                idxHouse + 1,
                idxCurColor,
                target - if (idxPrevColor == idxCurColor) 0 else 1,
                houses,
                costs,
                memo
            )
            minCost = minOf(minCost, curCost)
        }

        memo[idxHouse][target][idxPrevColor] = minCost
        return minCost
    }
}