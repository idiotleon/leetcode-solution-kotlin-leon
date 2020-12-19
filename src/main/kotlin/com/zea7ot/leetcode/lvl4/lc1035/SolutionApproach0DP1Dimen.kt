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

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
        val nNumsB = B.size

        val dp = IntArray(nNumsB + 1) { 0 }

        for (idxA in A.indices) {
            var prev = 0
            for (idxB in B.indices) {
                val cur = dp[idxB + 1]
                dp[idxB + 1] = if (A[idxA] == B[idxB]) {
                    1 + prev
                } else {
                    maxOf(dp[idxB], dp[idxB + 1])
                }
                prev = cur
            }
        }

        return dp.last()
    }
}