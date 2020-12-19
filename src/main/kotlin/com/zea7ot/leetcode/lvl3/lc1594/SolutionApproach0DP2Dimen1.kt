/**
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/discuss/855105/Java-Simple-DP-beat-100
 */
package com.zea7ot.leetcode.lvl3.lc1594

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun maxProductPath(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val dpMin = Array(nRows) { LongArray(nCols) { 0L } }
        dpMin[0][0] = grid[0][0].toLong()
        val dpMax = Array(nRows) { LongArray(nCols) { 0L } }
        dpMax[0][0] = grid[0][0].toLong()

        outer@ for (row in grid.indices) {
            inner@ for (col in grid[0].indices) {
                var min: Long
                var max: Long

                when {
                    row == 0 && col == 0 -> continue@inner
                    row == 0 -> {
                        dpMin[row][col] = grid[row][col] * dpMax[row][col - 1]
                        dpMax[row][col] = grid[row][col] * dpMax[row][col - 1]
                    }

                    col == 0 -> {
                        dpMin[row][col] = grid[row][col] * dpMax[row - 1][col]
                        dpMax[row][col] = grid[row][col] * dpMax[row - 1][col]
                    }

                    else -> {
                        max = grid[row][col] * maxOf(dpMax[row][col - 1], dpMax[row - 1][col])
                        min = grid[row][col] * minOf(dpMin[row][col - 1], dpMin[row - 1][col])

                        dpMax[row][col] = maxOf(min, max)
                        dpMin[row][col] = minOf(min, max)
                    }
                }
            }
        }

        val res = dpMax.last().last() % MOD
        return if (res < 0) -1 else res.toInt()
    }
}