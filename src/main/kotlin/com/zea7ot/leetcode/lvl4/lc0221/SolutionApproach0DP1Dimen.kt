/**
 * https://leetcode.com/problems/maximal-square/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/maximal-square/discuss/61803/C%2B%2B-space-optimized-DP
 */
package com.zea7ot.leetcode.lvl4.lc0221

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        // not used
        // val nRows = matrix.size
        val nCols = matrix[0].size

        var maxLen = 0
        var prev = 0
        val curRow = IntArray(nCols) { 0 }

        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                val cur = curRow[col]

                if (row == 0 || col == 0 || matrix[row][col] == '0') {
                    curRow[col] = matrix[row][col] - '0'
                } else {
                    curRow[col] = 1 + minOf(prev, curRow[col - 1], curRow[col])
                }

                maxLen = maxOf(maxLen, curRow[col])
                prev = cur
            }
        }

        return maxLen * maxLen
    }
}