/**
 * https://leetcode.com/problems/uncrossed-lines/
 *
 * Time Complexity:     O(`totalNumsA` * `totalNumsB`)
 * Space Complexity:    O(`totalNumsA` * `totalNumsB`)
 *
 * References:
 *  https://leetcode.com/problems/uncrossed-lines/discuss/282842/JavaC%2B%2BPython-DP-The-Longest-Common-Subsequence
 */
package com.zea7ot.leetcode.lvl4.lc1035

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val totalNumsA = A.size
        val totalNumsB = B.size

        val dp = Array(totalNumsA + 1) { IntArray(totalNumsB + 1) { 0 } }
        for (idxA in 1..totalNumsA) {
            for (idxB in 1..totalNumsB) {
                if (A[idxA - 1] == B[idxB - 1]) {
                    dp[idxA][idxB] = 1 + dp[idxA - 1][idxB - 1]
                } else {
                    dp[idxA][idxB] = maxOf(dp[idxA][idxB - 1], dp[idxA - 1][idxB])
                }
            }
        }

        return dp[totalNumsA][totalNumsB]
    }
}