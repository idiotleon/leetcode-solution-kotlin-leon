/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
 *  https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/441306/JavaC%2B%2BPython-DP-solution
 */
package com.idiotleon.leetcode.lvl3.lc1277

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun countSquares(matrix: Array<IntArray>): Int {
        var count = 0

        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                if (matrix[row][col] > 0 && row > 0 && col > 0) {
                    matrix[row][col] = 1 + minOf(matrix[row - 1][col - 1], matrix[row - 1][col], matrix[row][col - 1])
                }

                count += matrix[row][col]
            }
        }

        return count
    }
}