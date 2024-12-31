package com.idiotleon.leetcode.lvl2.lc2202

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1) / O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0MatrixManipulation {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        val nNums = original.size
        if (m * n != nNums) {
            return Array(0) { IntArray(0) }
        }

        val matrix = Array(m) { IntArray(n) { 0 } }

        var r = 0
        var c = 0

        for (num in original) {
            matrix[r][c] = num
            ++c
            if (c == n) {
                c = 0
                ++r
            }
        }

        return matrix
    }
}