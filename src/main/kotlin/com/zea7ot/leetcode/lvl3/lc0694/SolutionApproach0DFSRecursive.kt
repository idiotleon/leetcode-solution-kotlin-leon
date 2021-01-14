/**
 * https://leetcode.com/problems/number-of-distinct-islands/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/number-of-distinct-islands/discuss/108475/Java-very-Elegant-and-concise-DFS-Solution(Beats-100)/110671
 *  https://leetcode.com/problems/number-of-distinct-islands/discuss/108475/Java-very-Elegant-and-concise-DFS-Solution(Beats-100)
 */
package com.zea7ot.leetcode.lvl3.lc0694

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
        private val MOVES = charArrayOf('l', 'u', 'd', 'r')

        private const val WATER = 0
        private const val ISLAND = 1

        private const val SPLITTER = '#'
    }

    fun numDistinctIslands(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        val seen = HashSet<String>()

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == ISLAND) {
                    val builder = StringBuilder()
                    dfs(row, col, builder, grid)
                    val signature = builder.toString()
                    seen.add(signature)
                }
            }
        }

        return seen.size
    }

    private fun dfs(
        curRow: Int,
        curCol: Int,
        builder: StringBuilder,
        grid: Array<IntArray>
    ) {
        val nRows = grid.size
        val nCols = grid[0].size

        for (d in 0 until 4) {
            val nextRow = curRow + DIRS[d]
            val nextCol = curCol + DIRS[d + 1]

            if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols || grid[nextRow][nextCol] == WATER) continue
            val move = MOVES[d]
            builder.append(move)
            grid[nextRow][nextCol] = WATER
            dfs(nextRow, nextCol, builder, grid)
        }

        builder.append(SPLITTER)
    }
}