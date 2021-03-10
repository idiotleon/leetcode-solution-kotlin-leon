/**
 * https://leetcode.com/problems/triangle/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(`nRows`)
 *
 * a top-down approach to dissemble the problem into subproblems *
 * References:
 *  https://leetcode.com/problems/triangle/discuss/38724/7-lines-neat-Java-Solution/36485
 *  https://leetcode.com/problems/triangle/discuss/38732/My-8-line-DP-Java-code(4-meaningful-lines)-with-O(1)-space
 */
package com.an7one.leetcode.lvl3.lc0120.topDown

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen1 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val nRows = triangle.size

        val dp = IntArray(nRows) { 0 }.also {
            it[0] = triangle[0][0]
        }

        for (row in 1 until nRows) {
            val nCols = triangle[row].size
            for (col in triangle[row].indices.reversed()) {
                dp[col] = minOf(
                    if (col < nCols - 1) dp[col] else Int.MAX_VALUE,
                    if (col > 0) dp[col - 1] else Int.MAX_VALUE
                ) + triangle[row][col]
            }
        }

        return dp.min()!!
    }
}