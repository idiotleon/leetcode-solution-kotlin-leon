/**
 * https://leetcode.com/problems/rotate-image/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/rotate-image/discuss/18872/A-common-method-to-rotate-the-image
 */
package com.an7one.leetcode.lvl3.lc0048

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun rotate(matrix: Array<IntArray>) {
        reverseRows(matrix)
        transpose(matrix)
    }

    private fun transpose(matrix: Array<IntArray>) {
        for (row in matrix.indices) {
            for (col in 0 until row) {
                val temp = matrix[row][col]
                matrix[row][col] = matrix[col][row]
                matrix[col][row] = temp
            }
        }
    }

    private fun reverseRows(matrix: Array<IntArray>) {
        val nRows = matrix.size

        var lo = 0
        var hi = nRows - 1

        while (lo < hi) {
            val temp = matrix[lo]
            matrix[lo] = matrix[hi]
            matrix[hi] = temp

            ++lo
            --hi
        }
    }
}