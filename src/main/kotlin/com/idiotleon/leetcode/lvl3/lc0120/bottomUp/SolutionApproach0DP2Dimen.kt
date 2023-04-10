/**
 * https://leetcode.com/problems/triangle/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(`nRows` ^ 2)
 *
 * a bottom-up approach to dissemble the problem into subproblems
 *
 * References:
 *  https://leetcode.com/problems/triangle/discuss/159686/Java-Recursive-greaterTop-Down-greater-Bottom-up-greater-Bottom-Up-%2B-Optimal-Space
 */
package com.idiotleon.leetcode.lvl3.lc0120.bottomUp

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val nRows = triangle.size

        val dp = Array(nRows) { IntArray(nRows) { 0 } }.also {
            for (idx in triangle.last().indices) {
                it.last()[idx] = triangle.last()[idx]
            }
        }

        for (row in nRows - 2 downTo 0) {
            for (col in triangle[row].indices) {
                dp[row][col] = triangle[row][col] + minOf(dp[row + 1][col], dp[row + 1][col + 1])
            }
        }

        return dp[0][0]
    }
}