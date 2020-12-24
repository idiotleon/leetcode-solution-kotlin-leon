/**
 * https://leetcode.com/problems/triangle/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(`nRows` * `nColsLastRow`)
 *
 * References:
 *  https://leetcode.com/problems/triangle/discuss/159686/Java-Recursive-greaterTop-Down-greater-Bottom-up-greater-Bottom-Up-%2B-Optimal-Space
 */
package com.zea7ot.leetcode.lvl3.lc0120.topDown

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val nRows = triangle.size
        val nColsLastRow = triangle.last().size

        val memo = Array(nRows) { Array<Int?>(nColsLastRow) { null } }
        return dfs(0, 0, triangle, memo)
    }

    private fun dfs(row: Int, col: Int, triangle: List<List<Int>>, memo: Array<Array<Int?>>): Int {
        val nRows = triangle.size
        if (row + 1 >= nRows) {
            return triangle[row][col]
        }

        memo[row][col]?.let { return it }

        val min = triangle[row][col] + minOf(
            dfs(1 + row, col, triangle, memo),
            dfs(1 + row, 1 + col, triangle, memo)
        )

        memo[row][col] = min
        return min
    }
}