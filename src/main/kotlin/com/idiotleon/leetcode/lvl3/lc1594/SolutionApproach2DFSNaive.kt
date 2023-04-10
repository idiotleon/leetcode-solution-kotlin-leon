/**
 * this solution is NOT yet correct
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/discuss/855166/Java-DFS(Easy-to-understand)-and-DP(Best-time-complexity)
 */
package com.idiotleon.leetcode.lvl3.lc1594

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach2DFSNaive {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun maxProductPath(grid: Array<IntArray>): Int {
        val maxProduct = longArrayOf(-1L)
        dfs(0, 0, grid[0][0].toLong(), grid, maxProduct)
        return (maxProduct[0] % MOD).toInt()
    }

    private fun dfs(row: Int, col: Int, curProduct: Long, grid: Array<IntArray>, maxProduct: LongArray) {
        var curProduct = curProduct
        if (row == grid.lastIndex && col == grid[0].lastIndex) {
            maxProduct[0] = maxOf(maxProduct[0], curProduct)
            return
        }

        // pruning here
        if (grid[row][col] == 0) {
            curProduct = maxOf(curProduct, 0L)
            return
        }

        if (row + 1 <= grid.lastIndex) {
            dfs(row + 1, col, curProduct * grid[row + 1][col], grid, maxProduct)
        }

        if (col + 1 <= grid[0].lastIndex) {
            dfs(row, col + 1, curProduct * grid[row][col + 1], grid, maxProduct)
        }
    }
}