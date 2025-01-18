package com.idiotleon.leetcode.lvl4.lc0329

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-increasing-paths-in-a-matrix/
 *
 * a top-down approach
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0DfsMemo {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        // sanity check, required
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return 0
        }

        val nRows = matrix.size
        val nCols = matrix[0].size

        val memo = Array(nRows) { Array<Int?>(nCols) { null } }

        var longest = 1
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                longest = maxOf(longest, dfs(row, col, matrix, memo))
            }
        }

        return longest
    }

    private fun dfs(
        row: Int, col: Int, matrix: Array<IntArray>, memo: Array<Array<Int?>>
    ): Int {
        val nRows = matrix.size
        val nCols = matrix[0].size

        memo[row][col]?.let { return it }

        var longest = 1
        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]

            if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols) {
                continue
            }

            if (matrix[row][col] < matrix[nextRow][nextCol]) {
                longest = maxOf(longest, 1 + dfs(nextRow, nextCol, matrix, memo))
            }
        }

        memo[row][col] = longest
        return longest
    }
}