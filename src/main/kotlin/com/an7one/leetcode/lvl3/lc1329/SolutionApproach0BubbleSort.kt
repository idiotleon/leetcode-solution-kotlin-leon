/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 *
 * Time Complexity:     O((`nRows` ^ 2) * `nCols`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/sort-the-matrix-diagonally/discuss/489737/C%2B%2B-bubble-sort-clean-clear-and-easy
 */
package com.an7one.leetcode.lvl3.lc1329

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BubbleSort {
    fun diagonalSort(matrix: Array<IntArray>): Array<IntArray> {
        // not used
        // val nRows = matrix.size
        val nCols = matrix[0].size

        for (k in matrix.indices.reversed()) {
            for (row in 0 until k) {
                for (col in 0 until nCols - 1) {
                    if (matrix[row][col] > matrix[row + 1][col + 1]) {
                        swap(row, col, row + 1, col + 1, matrix)
                    }
                }
            }
        }

        return matrix
    }

    private fun swap(row1: Int, col1: Int, row2: Int, col2: Int, matrix: Array<IntArray>) {
        val temp = matrix[row1][col1]
        matrix[row1][col1] = matrix[row2][col2]
        matrix[row2][col2] = temp
    }
}