/**
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/discuss/855742/C%2B%2B-min-max-dp-solution-100-speed-with-picture-explanation-and-similar-problems
 */
package com.zea7ot.leetcode.lvl3.lc1594

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun maxProductPath(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val dpMin = Array(nRows) { LongArray(nCols) { 0L } }
        val dpMax = Array(nRows) { LongArray(nCols) { 0L } }

        grid[0][0].let {
            dpMin[0][0] = it.toLong()
            dpMax[0][0] = it.toLong()
        }

        for (row in 1 until nRows) {
            (grid[row][0] * dpMax[row - 1][0]).let {
                dpMax[row][0] = it
                dpMin[row][0] = it
            }
        }

        for (col in 1 until nCols) {
            (grid[0][col] * dpMax[0][col - 1]).let {
                dpMax[0][col] = it
                dpMin[0][col] = it
            }
        }

        for (row in 1 until nRows) {
            for (col in 1 until nCols) {
                dpMax[row][col] = maxOf(
                    maxOf(dpMax[row - 1][col], dpMax[row][col - 1]) * grid[row][col],
                    minOf(dpMin[row - 1][col], dpMin[row][col - 1]) * grid[row][col]
                )

                dpMin[row][col] = minOf(
                    maxOf(dpMax[row - 1][col], dpMax[row][col - 1]) * grid[row][col],
                    minOf(dpMin[row - 1][col], dpMin[row][col - 1]) * grid[row][col]
                )
            }
        }

        val res = dpMax.last().last() % MOD
        return if (res < 0) -1 else res.toInt()
    }
}