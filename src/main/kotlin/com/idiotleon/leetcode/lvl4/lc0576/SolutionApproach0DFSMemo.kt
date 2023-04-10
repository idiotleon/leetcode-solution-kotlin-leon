/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 *
 * Time Complexity:     O(`m` * `n` * `maxMove`)
 * Space Complexity:    O(`m` * `n` * `maxMove`)
 *
 * Reference:
 *  https://leetcode.com/problems/out-of-boundary-paths/discuss/119394/Java-DFS-with-memorization
 */
package com.idiotleon.leetcode.lvl4.lc0576

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)

        private const val MOD = 1e9.toLong() + 7
    }

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        val memo = Array(m) { Array(n) { Array<Long?>(maxMove + 1) { null } } }

        return (dfs(startRow, startColumn, maxMove, m, n, memo) % MOD).toInt()
    }

    private fun dfs(
        row: Int, col: Int,
        maxMove: Int,
        nRows: Int,
        nCols: Int,
        memo: Array<Array<Array<Long?>>>
    ): Long {
        if (row < 0 || row >= nRows || col < 0 || col >= nCols)
            return 1

        if (maxMove == 0)
            return 0

        memo[row][col][maxMove]?.let { return it }

        var count = 0L
        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]

            count += dfs(nextRow, nextCol, maxMove - 1, nRows, nCols, memo) % MOD
        }

        memo[row][col][maxMove] = count
        return count
    }
}