package com.an7one.leetcode.lvl1.lc0062

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/unique-paths/
 *
 * Time Complexity:     O(`m` * `n`)
 * Space Complexity:    O(`m` * `n`)
 *
 * Reference:
 * https://youtu.be/BxblkIz6TZc?t=512
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo1 {
    fun uniquePaths(m: Int, n: Int): Int {
        val memo = Array(m) { Array<Int?>(n) { null } }

        return dfs(0, 0, m, n, memo)
    }

    private fun dfs(
        row: Int, col: Int,
        m: Int, n: Int,
        memo: Array<Array<Int?>>
    ): Int {
        if (row >= m || col >= n) return 0
        if (row == m - 1 && col == n - 1) return 1

        memo[row][col]?.let { return it }

        val cntUniquePaths = dfs(row + 1, col, m, n, memo) + dfs(row, col + 1, m, n, memo)
        memo[row][col] = cntUniquePaths

        return cntUniquePaths
    }
}