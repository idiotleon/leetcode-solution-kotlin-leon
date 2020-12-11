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

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val nNumsA = A.size
        val nNumsB = B.size

        val dp = Array(nNumsA + 1) { IntArray(nNumsB + 1) { 0 } }

        for (idxA in 1..nNumsA) {
            for (idxB in 1..nNumsB) {
                dp[idxA][idxB] = if (A[idxA - 1] == B[idxB - 1]) {
                    1 + dp[idxA - 1][idxB - 1]
                } else {
                    maxOf(dp[idxA][idxB - 1], dp[idxA - 1][idxB])
                }
            }
        }

        return dp[nNumsA][nNumsB]
    }
}