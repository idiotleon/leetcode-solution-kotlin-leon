package com.idiotleon.leetcode.lvl4.lc1631

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 * Time Complexity:     O(`nRows` * `nCols` * max(`nRows`, `nCols`))
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * Reference:
 * https://zxi.mytechroad.com/blog/graph/leetcode-1631-path-with-minimum-effort/
 */
@Suppress(UNUSED)
class SolutionApproach2FloydWarshall {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val nRows = heights.size
        val nCols = heights[0].size

        val dp = Array(nRows) { IntArray(nCols) { Int.MAX_VALUE } }
        dp[0][0] = 0

        for (k in 0 until maxOf(nRows, nCols)) {
            for (row in 0 until nRows) {
                for (col in 0 until nCols) {
                    for (d in 0 until 4) {
                        val nextRow = row + DIRS[d]
                        val nextCol = col + DIRS[d + 1]

                        if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols) continue

                        dp[row][col] = minOf(
                            dp[row][col],
                            maxOf(dp[nextRow][nextCol], Math.abs(heights[nextRow][nextCol] - heights[row][col]))
                        )
                    }
                }
            }
        }

        return dp[nRows - 1][nCols - 1]
    }
}