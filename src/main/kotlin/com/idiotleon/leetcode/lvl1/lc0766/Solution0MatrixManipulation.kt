package com.idiotleon.leetcode.lvl1.lc0766

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/toeplitz-matrix
 *
 * Time Complexity:     O(`lenR` * `lenC`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0MatrixManipulation {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        val lenR = matrix.size
        val lenC = matrix[0].size

        for (r in 0 until lenR - 1) {
            for (c in 0 until lenC - 1) {
                if (matrix[r][c] != matrix[r + 1][c + 1]) {
                    return false
                }
            }
        }

        return true
    }
}