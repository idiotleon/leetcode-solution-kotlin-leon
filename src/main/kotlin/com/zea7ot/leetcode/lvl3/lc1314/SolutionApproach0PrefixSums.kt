/**
 * https://leetcode.com/problems/matrix-block-sum/
 *
 * Time Complexity:     O(`m` * `n`)
 * Space Complexity:    O(`m` * `n`)
 *
 * References:
 *  https://leetcode.com/problems/matrix-block-sum/discuss/477036/JavaPython-3-PrefixRange-sum-w-analysis-similar-to-LC-30478
 *  https://computersciencesource.wordpress.com/2010/09/03/computer-vision-the-integral-image/
 *  https://leetcode.com/problems/matrix-block-sum/discuss/477041/Java-Prefix-sum-with-Picture-explain-Clean-code-O(m*n)
 */
package com.zea7ot.leetcode.lvl3.lc1314

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums {
    fun matrixBlockSum(mat: Array<IntArray>, K: Int): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size

        val rangeSums = Array(m + 1) { IntArray(n + 1) { 0 } }
        for (row in 0 until m) {
            for (col in 0 until n) {
                rangeSums[row + 1][col + 1] = rangeSums[row + 1][col] + rangeSums[row][col + 1] - rangeSums[row][col] + mat[row][col]
            }
        }

        val ans = Array(m) { IntArray(n) { 0 } }
        for (row in 0 until m) {
            for (col in 0 until n) {
                val row1 = maxOf(0, row - K)
                val col1 = maxOf(0, col - K)
                val row2 = minOf(m, row + K + 1)
                val col2 = minOf(n, col + K + 1)

                ans[row][col] = rangeSums[row2][col2] - rangeSums[row2][col1] - rangeSums[row1][col2] + rangeSums[row1][col1]
            }
        }

        return ans
    }
}