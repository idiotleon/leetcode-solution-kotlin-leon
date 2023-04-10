package com.idiotleon.leetcode.lvl2.lc0566

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/reshape-the-matrix/
 *
 * Time Complexity:     O(`r` * `c`)
 * Space Complexity:    O(`r` * `c`)
 *
 * Reference:
 *  https://leetcode.com/problems/reshape-the-matrix/discuss/102491/Java-Concise-O(nm)-time
 */
@Suppress(UNUSED)
class SolutionApproach0MatrixManipulation {
    fun matrixReshape(matrix: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val nRows = matrix.size
        val nCols = matrix[0].size

        if (nRows * nCols != r * c)
            return matrix

        val res = Array(r) { IntArray(c) { 0 } }
        for (idx in 0 until r * c) {
            res[idx / c][idx % c] = matrix[idx / nCols][idx % nCols]
        }

        return res
    }
}