/**
 * @author: Leon
 *
 * Time Complexity:     O(`nRows` ^ 2)
 * Space Complexity:    O(`nRows` ^ 2)
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/35/
 */
package com.an7one.summary.byAlgorithm.dynamicProgramming.linear.triangle

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP2Dimen {
    fun getMaxValue(triangle: List<List<Int>>): Int {
        val nRows = triangle.size

        val dp = Array(nRows + 1) { IntArray(nRows + 1) { 0 } }.also {
            for (row in 1..nRows) {
                for (col in 1..row + 1) {
                    it[row][col] = Int.MIN_VALUE
                }
            }

            it[1][1] = triangle[1][1]
        }

        for (row in 2..nRows) {
            for (col in 1..row) {
                dp[row][col] = maxOf(dp[row - 1][col], dp[row - 1][col - 1]) + triangle[row][col]
            }
        }

        var max = Int.MIN_VALUE
        for (idx in 1..nRows) {
            max = maxOf(max, dp.last()[idx])
        }
        return max
    }
}