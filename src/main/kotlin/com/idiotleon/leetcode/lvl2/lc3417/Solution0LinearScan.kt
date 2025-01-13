package com.idiotleon.leetcode.lvl2.lc3417

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/zigzag-grid-traversal-with-skip/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(1) / O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun zigzagTraversal(grid: Array<IntArray>): List<Int> {
        val nRows = grid.size
        val nCols = grid[0].size

        val ans = mutableListOf<Int>()

        var count = 0
        for (r in 0 until nRows) {
            for (c in 0 until nCols) {
                if (count++ % 2 == 1) {
                    continue
                }
                val c = if (r % 2 == 0) c else nCols - c - 1
                ans.add(grid[r][c])
            }
        }

        return ans
    }
}