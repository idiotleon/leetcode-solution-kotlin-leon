/**
 * @author: Leon
 * https://leetcode.com/problems/uncrossed-lines/
 *
 * Time Complexity:     O(`nNumsA` * `nNumsB`)
 * Space Complexity:    O(`nNumsA` * `nNumsB`)
 */
package com.zea7ot.leetcode.lvl4.lc1035

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val nNumsA = A.size
        val nNumsB = B.size

        val dp = Array(nNumsA + 1) { IntArray(nNumsB + 1) { 0 } }

        for (idxA in A.indices) {
            for (idxB in B.indices) {
                dp[idxA + 1][idxB + 1] = if (A[idxA] == B[idxB]) {
                    1 + dp[idxA][idxB]
                } else {
                    maxOf(dp[idxA][idxB + 1], dp[idxA + 1][idxB])
                }
            }
        }

        return dp[nNumsA][nNumsB]
    }
}