/**
 * https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
 *
 * Time Complexity:     O(`k` * `nRows` * `nCols` * (`nRows` + `nCols`))
 * Space Complexity:    O(`k` * `nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/discuss/623732/JavaC%2B%2BPython-DP-%2B-PrefixSum-in-Matrix-Clean-code
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1444-number-of-ways-of-cutting-a-pizza/
 *  https://youtu.be/q2Wh5v___r8
 */
package com.an7one.leetcode.lvl4.lc1444

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val MOD = 1e9.toInt() + 7

        private const val APPLE = 'A'
    }

    fun ways(pizza: Array<String>, k: Int): Int {
        val nRows = pizza.size
        val nCols = pizza[0].length

        val memo = Array(k) { Array(nRows) { Array<Int?>(nCols) { null } } }

        // suffixSums[row][col] is the total apples left in the pizza[row:][col:]
        val suffixSums = Array(nRows + 1) { IntArray(nCols + 1) { 0 } }
        for (row in nRows - 1 downTo 0) {
            for (col in nCols - 1 downTo 0) {
                suffixSums[row][col] =
                    suffixSums[row][col + 1] + suffixSums[row + 1][col] - suffixSums[row + 1][col + 1] + if (pizza[row][col] == APPLE) 1 else 0
            }
        }

        return dfs(0, 0, k - 1, nRows, nCols, suffixSums, memo)
    }

    private fun dfs(
        row: Int,
        col: Int,
        k: Int,
        nRows: Int, nCols: Int,
        suffixSums: Array<IntArray>,
        memo: Array<Array<Array<Int?>>>
    ): Int {
        // if there is no apple left
        if (suffixSums[row][col] == 0) return 0

        // the pizza has been cut `k` times already
        if (k == 0) return 1
        memo[k][row][col]?.let { return it }

        var count = 0
        // to cut the pizza horizontally
        for (cutIdx in row + 1 until nRows) {
            if (suffixSums[row][col] - suffixSums[cutIdx][col] > 0) {
                count += dfs(cutIdx, col, k - 1, nRows, nCols, suffixSums, memo) % MOD
                count %= MOD
            }
        }

        // to cut the pizza vertically
        for (cutIdx in col + 1 until nCols) {
            if (suffixSums[row][col] - suffixSums[row][cutIdx] > 0) {
                count += dfs(row, cutIdx, k - 1, nRows, nCols, suffixSums, memo) % MOD
                count %= MOD
            }
        }

        memo[k][row][col] = count
        return count
    }
}