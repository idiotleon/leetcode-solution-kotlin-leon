/**
 * https://leetcode.com/problems/triangle/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(`nRows`)
 *
 * a bottom-up approach to dissemble the problem into subproblems *
 *
 * References:
 *  https://leetcode.com/problems/triangle/discuss/38724/7-lines-neat-Java-Solution
 *  https://leetcode.com/problems/triangle/discuss/38732/My-8-line-DP-Java-code(4-meaningful-lines)-with-O(1)-space
 */
package com.idiotleon.leetcode.lvl3.lc0120.bottomUp

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val nRows = triangle.size
        val dp = IntArray(1 + nRows) { 0 }

        for (row in triangle.indices.reversed()) {
            val curRow = triangle[row]

            for (col in curRow.indices) {
                dp[col] = minOf(dp[col], dp[col + 1]) + curRow[col]
            }
        }

        return dp[0]
    }
}