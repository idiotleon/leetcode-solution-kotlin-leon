/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * Reference:
 *  https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/553574/Java-DFS-Solution-Clean-code
 */
package com.an7one.leetcode.lvl3.lc1391

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private val STREETS = arrayOf(
            arrayOf(intArrayOf(0, -1), intArrayOf(0, 1)),
            arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0)),
            arrayOf(intArrayOf(0, -1), intArrayOf(1, 0)),
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)),
            arrayOf(intArrayOf(0, -1), intArrayOf(-1, 0)),
            arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1))
        )
    }

    fun hasValidPath(grid: Array<IntArray>): Boolean {
        val nRows = grid.size
        val nCols = grid[0].size

        val visited = Array(nRows) { BooleanArray(nCols) { false } }
        return dfs(0, 0, visited, grid)
    }

    private fun dfs(row: Int, col: Int, visited: Array<BooleanArray>, grid: Array<IntArray>): Boolean {
        val nRows = grid.size
        val nCols = grid[0].size

        if (row == nRows - 1 && col == nCols - 1) return true
        visited[row][col] = true

        for ((dirRow, dirCol) in STREETS[grid[row][col] - 1]) {
            val nextRow = row + dirRow
            val nextCol = col + dirCol

            if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols || visited[nextRow][nextCol]) continue

            for ((backRow, backCol) in STREETS[grid[nextRow][nextCol] - 1]) {
                if (nextRow + backRow == row && nextCol + backCol == col) {
                    if (dfs(nextRow, nextCol, visited, grid)) return true
                }
            }
        }

        return false
    }
}