/**
 * @author: Leon
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  Paid Course, 59min: https://www.acwing.com/video/35/
 */
package com.an7one.summary.byAlgorithm.dynamicProgramming.linear.lcs

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DP2Dimen {
    fun longestCommonSubsequence(): Int {
        val n = readLine()!!.toInt()
        val m = readLine()!!.toInt()

        val nums1 = IntArray(n + 1) { 0 }
        for (idx in 1..n) {
            nums1[idx] = readLine()!!.toInt()
        }

        val nums2 = IntArray(m + 1) { 0 }
        for (idx in 1..m) {
            nums2[idx] = readLine()!!.toInt()
        }

        val dp = Array(n + 1) { IntArray(m + 1) { 0 } }

        for (idx1 in 1..n) {
            for (idx2 in 1..m) {
                dp[idx1][idx2] = maxOf(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1])

                if (nums1[idx1] == nums2[idx2]) {
                    dp[idx1][idx2] = maxOf(dp[idx1][idx2], 1 + dp[idx1 - 1][idx2 - 1])
                }
            }
        }

        return dp[n][m]
    }
}