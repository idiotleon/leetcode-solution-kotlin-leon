/**
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 *
 * Time Complexity:     O(`totalRows` * `totalCols`)
 * Space Complexity:    O(`totalRows` * `totalCols`)
 *
 * References:
 *  https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/discuss/876833/JavaPython-3-O(m-%2B-n)-codes-w-analysis%3A-Put-into-current-cell-the-less-of-the-remaining-values
 */
package com.an7one.leetcode.lvl4.lc1605

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun restoreMatrix(rowSums: IntArray, colSums: IntArray): Array<IntArray> {
        val nRows = rowSums.size
        val nCols = colSums.size

        val matrix = Array(nRows) { IntArray(nCols) { 0 } }

        var row = 0
        var col = 0

        while (row < nRows && col < nCols) {
            matrix[row][col] = minOf(rowSums[row], colSums[col])
            rowSums[row] -= matrix[row][col]
            colSums[col] -= matrix[row][col]
            row += if (rowSums[row] == 0) 1 else 0
            col += if (colSums[col] == 0) 1 else 0
        }

        return matrix
    }
}