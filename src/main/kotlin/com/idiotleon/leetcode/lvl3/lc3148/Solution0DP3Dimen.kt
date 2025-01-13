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
 * https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/solutions/6267383/dp-tabulation-c-easy/
 */
@Suppress(UNUSED)
class Solution0DP3Dimen {
    private companion object {
        private const val RANGE = 1000 * 500 * 500 + 7
    }

    fun maximumAmount(coins: Array<IntArray>): Int {
        val nRows = coins.size
        val nCols = coins[0].size

        val dp = Array(nRows) { Array(nCols) { IntArray(3) { -RANGE } } }

        for (k in 0 until 3) {
            for (r in nRows - 1 downTo 0) {
                for (c in nCols - 1 downTo 0) {
                    if (r == nRows - 1 && c == nCols - 1) {
                        dp[r][c][k] = if (k > 0) maxOf(0, coins[r][c]) else coins[r][c]
                        continue
                    }

                    var res = -RANGE

                    if (r + 1 < nRows) {
                        res = maxOf(res, coins[r][c] + dp[r + 1][c][k])
                        if (k > 0) {
                            res = maxOf(res, dp[r + 1][c][k - 1])
                        }
                    }

                    if (c + 1 < nCols) {
                        res = maxOf(res, coins[r][c] + dp[r][c + 1][k])
                        if (k > 0) {
                            res = maxOf(res, dp[r][c + 1][k - 1])
                        }
                    }

                    dp[r][c][k] = res
                }
            }
        }

        return dp[0][0][2]
    }
}