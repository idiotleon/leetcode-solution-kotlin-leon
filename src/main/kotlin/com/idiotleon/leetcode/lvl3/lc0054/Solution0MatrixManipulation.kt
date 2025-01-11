package com.idiotleon.leetcode.lvl3.lc0054

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/spiral-matrix/solutions/6254926/100-beats-elegant-spiral-order-traversal-navigating-a-matrix-with-precision/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 */
@Suppress(UNUSED)
class Solution0MatrixManipulation {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val nRows = matrix.size
        val nCols = matrix[0].size

        var top = 0
        var bottom = nRows - 1
        var low = 0
        var high = nCols - 1

        val ans = mutableListOf<Int>()
        while (true) {
            for (c in low..high) {
                ans.add(matrix[top][c])
            }
            ++top
            if (low > high || top > bottom) {
                break
            }
            for (r in top..bottom) {
                ans.add(matrix[r][high])
            }
            --high
            if (low > high || top > bottom) {
                break
            }
            for (c in high downTo low) {
                ans.add(matrix[bottom][c])
            }
            --bottom
            if (low > high || top > bottom) {
                break
            }
            for (r in bottom downTo top) {
                ans.add(matrix[r][low])
            }
            ++low
            if (low > high || top > bottom) {
                break
            }
        }

        return ans
    }
}