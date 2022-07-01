package com.an7one.leetcode.lvl3.lc0073

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
 */
@Suppress(UNUSED)
class SolutionApproach0MatrixManipulation {
    fun setZeroes(matrix: Array<IntArray>) {
        val nRows = matrix.size
        val nCols = matrix[0].size

        var firstRow = false
        var firstCol = false

        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                if (matrix[row][col] == 0) {
                    if (row == 0) firstRow = true

                    if (col == 0) firstCol = true

                    matrix[0][col] = 0
                    matrix[row][0] = 0
                }
            }
        }

        for (row in 1 until nRows) {
            for (col in 1 until nCols) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) matrix[row][col] = 0
            }
        }

        if (firstRow) for (col in matrix[0].indices) {
            matrix[0][col] = 0
        }

        if (firstCol) for (row in matrix.indices) {
            matrix[row][0] = 0
        }
    }
}