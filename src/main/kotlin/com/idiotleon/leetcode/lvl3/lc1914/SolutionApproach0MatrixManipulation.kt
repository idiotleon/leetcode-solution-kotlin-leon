/**
 * https://leetcode.com/problems/cyclically-rotating-a-grid/
 *
 * Time Complexity:     O(`nRows` * `nCols` * `k`)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/cyclically-rotating-a-grid/discuss/1299576/Extremely-Easy-O(M-*-N)-Solution-or-100-Time/989272
 */
package com.idiotleon.leetcode.lvl3.lc1914

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0MatrixManipulation {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val nRows = grid.size
        val nCols = grid[0].size

        var left = 0
        var right = nCols - 1
        var top = 0
        var bottom = nRows - 1

        while (left < right && top < bottom) {
            val localK = k % ((bottom - top) * 2 + (right - left) * 2)
            for (rotate in 0 until localK) {
                val hold = grid[top][left]

                for (col in left until right) {
                    grid[top][col] = grid[top][col + 1]
                }

                for (row in top until bottom) {
                    grid[row][right] = grid[row + 1][right]
                }

                for (col in right downTo left + 1) {
                    grid[bottom][col] = grid[bottom][col - 1]
                }

                for (row in bottom downTo top + 1) {
                    grid[row][left] = grid[row - 1][left]
                }

                grid[top + 1][left] = hold
            }

            ++left
            --right
            ++top
            --bottom
        }

        return grid
    }
}