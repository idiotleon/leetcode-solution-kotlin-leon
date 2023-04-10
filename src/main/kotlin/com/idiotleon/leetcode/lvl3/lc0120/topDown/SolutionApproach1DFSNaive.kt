/**
 * https://leetcode.com/problems/triangle/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * TLEed
 *
 * References:
 *  https://leetcode.com/problems/triangle/discuss/159686/Java-Recursive-greaterTop-Down-greater-Bottom-up-greater-Bottom-Up-%2B-Optimal-Space
 */
package com.idiotleon.leetcode.lvl3.lc0120.topDown

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1DFSNaive {
    fun minimumTotal(triangle: List<List<Int>>) = dfs(0, 0, triangle)

    private fun dfs(row: Int, col: Int, triangle: List<List<Int>>): Int {
        val nRows = triangle.size
        if (row + 1 >= nRows) {
            return triangle[row][col]
        }

        return triangle[row][col] + minOf(
            dfs(1 + row, col, triangle),
            dfs(1 + row, 1 + col, triangle)
        )
    }
}