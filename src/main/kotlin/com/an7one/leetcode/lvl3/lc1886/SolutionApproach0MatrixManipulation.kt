/**
 * @author: Leon
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 *
 * Time Complexity:     O(nRows * nCols)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc1886

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0MatrixManipulation {
    fun findRotation(matrix: Array<IntArray>, target: Array<IntArray>): Boolean {
        for (d in 0 until 4) {
            if (d > 0)
                rotate(matrix)

            if (isEqual(matrix, target))
                return true
        }

        return false
    }

    private fun rotate(matrix: Array<IntArray>) {
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

    private fun isEqual(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Boolean {
        for (row in matrix1.indices) {
            for (col in matrix1[row].indices) {
                if (matrix1[row][col] != matrix2[row][col])
                    return false
            }
        }

        return true
    }
}