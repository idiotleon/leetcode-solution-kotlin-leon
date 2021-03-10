/**
 * https://leetcode.com/problems/triangle/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(`nRows`)
 *
 * a bottom-up approach to dissemble the problem into subproblems *
 *
 * References:
 *  https://leetcode.com/problems/triangle/discuss/159686/Java-Recursive-greaterTop-Down-greater-Bottom-up-greater-Bottom-Up-%2B-Optimal-Space
 */
package com.an7one.leetcode.lvl3.lc0120.bottomUp

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen1 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val nRows = triangle.size

        var dp = IntArray(nRows) { 0 }.also {
            for (col in triangle.last().indices) {
                it[col] = triangle.last()[col]
            }
        }

        val next = IntArray(nRows) { 0 }

        for (row in nRows - 2 downTo 0) {
            for (col in triangle[row].indices) {
                next[col] = triangle[row][col] + minOf(dp[col + 1], dp[col])
            }

            dp = next
        }

        return dp[0]
    }
}