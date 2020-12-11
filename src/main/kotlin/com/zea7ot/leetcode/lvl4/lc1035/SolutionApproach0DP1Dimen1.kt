/**
 * https://leetcode.com/problems/uncrossed-lines/
 *
 * Time Complexity:     O(`nNumsA` * `nNumsB`)
 * Space Complexity:    O(`nNumsB`)
 *
 * References:
 *  https://leetcode.com/problems/uncrossed-lines/discuss/282842/JavaC%2B%2BPython-DP-The-Longest-Common-Subsequence
 */
package com.zea7ot.leetcode.lvl4.lc1035

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen1 {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val nNumsA = A.size
        val nNumsB = B.size

        val dp = IntArray(nNumsB + 1) { 0 }

        for (idxA in 1..nNumsA) {
            var prev = 0
            for (idxB in 1..nNumsB) {
                val cur = dp[idxB]
                dp[idxB] = if (A[idxA - 1] == B[idxB - 1]) {
                    1 + prev
                } else {
                    maxOf(dp[idxB - 1], dp[idxB])
                }

                prev = cur
            }
        }

        return dp.last()
    }
}