/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 * Time Complexity:     O(`totalRows` * `totalCols` * max(`totalRows`, `totalCols`))
 * Space Complexity:    O(`totalRows` * `totalCols`)
 *
 * References:
 *  https://zxi.mytechroad.com/blog/graph/leetcode-1631-path-with-minimum-effort/
 */
package com.an7one.leetcode.lvl4.lc1631

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach2FloydWarshall {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val totalRows = heights.size
        val totalCols = heights[0].size

        val dp = Array(totalRows) { IntArray(totalCols) { Int.MAX_VALUE } }
        dp[0][0] = 0

        for (k in 0 until maxOf(totalRows, totalCols)) {
            for (row in 0 until totalRows) {
                for (col in 0 until totalCols) {
                    for (d in 0 until 4) {
                        val nextRow = row + DIRS[d]
                        val nextCol = col + DIRS[d + 1]

                        if (nextRow < 0 || nextRow >= totalRows || nextCol < 0 || nextCol >= totalCols) continue

                        dp[row][col] = minOf(
                            dp[row][col],
                            maxOf(dp[nextRow][nextCol], Math.abs(heights[nextRow][nextCol] - heights[row][col]))
                        )
                    }
                }
            }
        }

        return dp[totalRows - 1][totalCols - 1]
    }
}