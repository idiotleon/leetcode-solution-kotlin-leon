/**
 * https://leetcode.com/problems/longest-increasing-paths-in-a-matrix/
 *
 * a top-down approach
 *
 * Time Complexity:     O(`totalRows` * `totalCols`)
 * Space Complexity:    O(`totalRows` * `totalCols`)
 */
package com.zea7ot.leetcode.lvl4.lc0329

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private val DIRS = arrayOf(0, -1, 0, 1, 0)
    }

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        // sanity check, required
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0

        val totalRows = matrix.size
        val totalCols = matrix[0].size

        val memo = Array(totalRows) { Array<Int?>(totalCols) { null } }

        var longest = 1
        for (row in 0 until totalRows) {
            for (col in 0 until totalCols) {
                longest = maxOf(longest, dfs(row, col, matrix, memo))
            }
        }

        return longest
    }

    private fun dfs(row: Int,
                    col: Int,
                    matrix: Array<IntArray>,
                    memo: Array<Array<Int?>>): Int {
        val nRows = matrix.size
        val nCols = matrix[0].size

        memo[row][col]?.let { return it }

        var longest = 1
        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]

            if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols) continue

            if (matrix[row][col] < matrix[nextRow][nextCol]) {
                longest = maxOf(longest, 1 + dfs(nextRow, nextCol, matrix, memo))
            }
        }

        memo[row][col] = longest
        return longest
    }
}