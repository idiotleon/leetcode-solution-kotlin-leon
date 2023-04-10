package com.idiotleon.leetcode.lvl4.lc0135

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/candy/
 *
 * Time Complexity:     O(`nRtgs`)
 * Space Complexity:    O(`nRtgs`)
 *
 * Reference:
 * https://leetcode.com/problems/candy/discuss/42769/A-simple-solution/336970
 * https://leetcode.com/problems/candy/discuss/42769/A-simple-solution/41219
 * https://leetcode.com/problems/candy/discuss/42769/A-simple-solution
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun candy(ratings: IntArray): Int {
        val nRtgs = ratings.size
        val dp = IntArray(nRtgs) { 1 }

        for (idx in 1 until nRtgs) {
            if (ratings[idx] > ratings[idx - 1]) dp[idx] = dp[idx - 1] + 1
        }

        for (idx in nRtgs - 1 downTo 1) {
            if (ratings[idx - 1] > ratings[idx]) dp[idx - 1] = maxOf(dp[idx] + 1, dp[idx - 1])
        }

        return dp.sum()
    }
}