/**
 * https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
 *
 * Time Complexity:     O(`k` * `nRows` * `nCols` * (`nRows` + `nCols`))
 * Space Complexity:    O(`k` * `nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/discuss/632619/Java-bottom-up-3D-dp-with-post-sum-and-explanation
 */
package com.zea7ot.leetcode.lvl4.lc1444

class SolutionApproach0DP3Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
        private const val APPLE = 'A'
    }

    fun ways(pizza: Array<String>, k: Int): Int {
        val nRows = pizza.size
        val nCols = pizza[0].length

        // postfix sums
        val postfixSums = Array(nRows + 1) { IntArray(nCols + 1) { 0 } }
        for (row in nRows - 1 downTo 0) {
            for (col in nCols - 1 downTo 0) {
                postfixSums[row][col] += postfixSums[row + 1][col] + postfixSums[row][col + 1] - postfixSums[row + 1][col + 1]
                postfixSums[row][col] += if (pizza[row][col] == APPLE) 1 else 0
            }
        }

        val dp = Array(k + 1) { Array(nRows) { Array(nCols) { 0 } } }
        // base case
        for (row in nRows - 1 downTo 0) {
            for (col in nCols - 1 downTo 0) {
                if (postfixSums[row][col] > 0) {
                    dp[1][row][col] = 1
                }
            }
        }

        for (cut in 2..k) {
            for (row in nRows - 1 downTo 0) {
                for (col in nCols - 1 downTo 0) {

                    // to cut the pizza horizontally
                    for (cutIdx in row + 1 until nRows) {
                        if (postfixSums[row][col] - postfixSums[cutIdx][col] > 0) {
                            dp[cut][row][col] += dp[cut - 1][cutIdx][col] % MOD
                            dp[cut][row][col] %= MOD
                        }
                    }

                    // to cut the pizza vertically
                    for (cutIdx in col + 1 until nCols) {
                        if (postfixSums[row][col] - postfixSums[row][cutIdx] > 0) {
                            dp[cut][row][col] += dp[cut - 1][row][cutIdx] % MOD
                            dp[cut][row][col] %= MOD
                        }
                    }
                }
            }
        }

        return dp[k][0][0]
    }
}