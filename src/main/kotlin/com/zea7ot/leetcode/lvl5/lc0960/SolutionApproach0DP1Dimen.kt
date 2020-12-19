/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-iii/
 *
 * Time Complexity:     O(`nStrs` * (`lenS` ^ 2))
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/delete-columns-to-make-sorted-iii/
 *  https://leetcode.com/problems/delete-columns-to-make-sorted-iii/discuss/205679/C%2B%2BJavaPython-Maximum-Increasing-Subsequence
 */
package com.zea7ot.leetcode.lvl5.lc0960

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minDeletionSize(strs: Array<String>): Int {
        val nStrs = strs.size
        val lenS = strs[0].length

        val dp = IntArray(lenS) { 1 }
        var longest = 0

        for (hi in 0 until lenS) {
            for (lo in 0 until hi) {
                for (idx in 0..nStrs) {
                    if (idx == nStrs) dp[hi] = maxOf(dp[hi], 1 + dp[lo])
                    else if (strs[idx][lo] > strs[idx][hi]) break
                }
            }

            longest = maxOf(longest, dp[hi])
        }

        return lenS - longest
    }
}