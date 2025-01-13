package com.idiotleon.leetcode.lvl3.lc3148

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/solutions/6267298/iterative-dp-reccursive-dp-memoization-clean-code/
 */
@Suppress(UNUSED)
class SolutionTleDfsMemo {
    private companion object {
        private const val RANGE = 500 + 1
    }

    fun maximumAmount(coins: Array<IntArray>): Int {
        val memo = Array(RANGE) { Array(RANGE) { Array<Int?>(3) { null } } }
        return dfs(0, 0, 2, coins, memo)
    }

    private fun dfs(r: Int, c: Int, k: Int, coins: Array<IntArray>, memo: Array<Array<Array<Int?>>>): Int {
        val nRows = coins.size
        val nCols = coins[0].size

        if (r == nRows - 1 && c == nCols - 1) {
            return if (k > 0 && coins[r][c] < 0) {
                0
            } else {
                coins[r][c]
            }
        }

        if (r >= nRows || c >= nCols) {
            return Int.MIN_VALUE
        }

        memo[r][c][k]?.let { return it }

        var take = Int.MIN_VALUE
        var notTake = Int.MIN_VALUE
        take = coins[r][c] + maxOf(dfs(r + 1, c, k, coins, memo), dfs(r, c + 1, k, coins, memo))
        if (k > 0 && coins[r][c] < 0) {
            notTake = maxOf(dfs(r + 1, c, k - 1, coins, memo), dfs(r, c + 1, k - 1, coins, memo))
        }
        val max = maxOf(take, notTake)
        memo[r][c][k] = max
        return max
    }
}