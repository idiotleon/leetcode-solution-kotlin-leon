/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 *
 * Time Complexity:     O(`m` * `n` * `maxMove`)
 * Space Complexity:    O(`m` * `n`)
 *
 * Reference:
 *  https://leetcode.com/problems/out-of-boundary-paths/discuss/102967/Java-Solution-DP-with-space-compression
 */
package com.idiotleon.leetcode.lvl4.lc0576

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        var dp = Array(m) { IntArray(n) { 0 } }.also {
            it[startRow][startColumn] = 1
        }

        var count = 0

        for (step in 0 until maxMove) {
            val dpNext = Array(m) { IntArray(n) { 0 } }

            for (row in 0 until m) {
                for (col in 0 until n) {
                    if (dp[row][col] == 0)
                        continue

                    for (d in 0 until 4) {
                        val nextRow = row + DIRS[d]
                        val nextCol = col + DIRS[d + 1]

                        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                            count = (count + dp[row][col]) % MOD
                        } else {
                            dpNext[nextRow][nextCol] = (dpNext[nextRow][nextCol] + dp[row][col]) % MOD
                        }
                    }
                }
            }

            dp = dpNext
        }

        return count
    }
}