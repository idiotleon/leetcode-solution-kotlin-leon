package com.idiotleon.leetcode.lvl3.lc1886

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/solutions/1254089/c-straightforward-solution-comparing-in-place/comments/964020
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/solutions/1254089/c-straightforward-solution-comparing-in-place/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 */
@Suppress(UNUSED)
class Solution0MatrixManipulation {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val nRows = mat.size
        val nCols = mat[0].size

        var theSame = true
        var rotation90 = true
        var rotation180 = true
        var rotation270 = true

        for (r in 0 until nRows) {
            for (c in 0 until nCols) {
                if (mat[r][c] != target[r][c]) {
                    theSame = false
                }
                if (mat[r][c] != target[nRows - c - 1][r]) {
                    rotation90 = false
                }
                if (mat[r][c] != target[nRows - r - 1][nRows - c - 1]) {
                    rotation180 = false
                }
                if (mat[r][c] != target[c][nRows - r - 1]) {
                    rotation270 = false
                }
            }
        }

        return theSame || rotation90 || rotation180 || rotation270
    }
}