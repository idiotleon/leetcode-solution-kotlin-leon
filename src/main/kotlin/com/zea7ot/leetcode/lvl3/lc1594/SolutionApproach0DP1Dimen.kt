/**
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nCols`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/discuss/855105/Java-Simple-DP-beat-100/705378
 *  https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/discuss/855105/Java-Simple-DP-beat-100
 */
package com.zea7ot.leetcode.lvl3.lc1594

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun maxProductPath(grid: Array<IntArray>): Int {
        // not used
        // val nRows = grid.size
        val nCols = grid[0].size

        val dpMin = LongArray(nCols)
        dpMin[0] = grid[0][0].toLong()

        val dpMax = LongArray(nCols)
        dpMax[0] = grid[0][0].toLong()

        outer@ for (row in grid.indices) {
            inner@ for (col in grid[0].indices) {
                if (row == 0 && col == 0) continue@inner

                var min = Long.MAX_VALUE
                var max = Long.MIN_VALUE

                if (row > 0) {
                    min = minOf(grid[row][col] * dpMin[col], grid[row][col] * dpMax[col])
                    max = maxOf(grid[row][col] * dpMin[col], grid[row][col] * dpMax[col])
                }

                if (col > 0) {
                    min = minOf(min, grid[row][col] * dpMin[col - 1], grid[row][col] * dpMax[col - 1])
                    max = maxOf(max, grid[row][col] * dpMin[col - 1], grid[row][col] * dpMax[col - 1])
                }

                dpMin[col] = min
                dpMax[col] = max
            }
        }

        val res = (dpMax.last() % MOD).toInt()
        return if (res < 0) -1 else res
    }
}