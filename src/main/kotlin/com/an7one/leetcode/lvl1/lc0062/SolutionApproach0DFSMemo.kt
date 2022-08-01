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
 * https://youtu.be/BxblkIz6TZc?t=518
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun uniquePaths(m: Int, n: Int): Int {
        val memo = Array(m) { Array<Int?>(n) { null } }
        return dfs(m - 1, n - 1, memo)
    }

    private fun dfs(row: Int, col: Int, memo: Array<Array<Int?>>): Int {
        if (row < 0 || col < 0) return 0

        if (row == 0 && col == 0) return 1

        memo[row][col]?.let { return it }
        val cntUniquePaths = dfs(row - 1, col, memo) + dfs(row, col - 1, memo)
        memo[row][col] = cntUniquePaths
        return cntUniquePaths
    }
}