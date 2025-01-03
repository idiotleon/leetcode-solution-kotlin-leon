package com.idiotleon.leetcode.lvl1.lc0867

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/transpose-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(1) / O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0MatrixManipulation {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val nRows = matrix.size
        val nCols = matrix[0].size

        val ans = Array(nCols) { IntArray(nRows) { 0 } }

        for (r in 0 until nRows) {
            for (c in 0 until nCols) {
                ans[c][r] = matrix[r][c]
            }
        }

        return ans
    }
}