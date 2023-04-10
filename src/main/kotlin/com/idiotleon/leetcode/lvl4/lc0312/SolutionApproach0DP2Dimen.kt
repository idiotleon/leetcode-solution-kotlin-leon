package com.idiotleon.leetcode.lvl4.lc0312

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/burst-balloons/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * `dp[i][j]`, the maximum score with any one balloon within `nums[i : j]` bursted
 *
 * Reference:
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-312-burst-balloons/
 * https://youtu.be/z3hu2Be92UA
 * https://youtu.be/FLbqgyJ-70I?t=7040
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxCoins(nums: IntArray): Int {
        val nNums = nums.size
        val nPadded = nNums + 2

        // to pad both ends of `nums` array with 1
        val padded = IntArray(nPadded) { idx ->
            when (idx) {
                0 -> 1
                nNums + 1 -> 1
                else -> nums[idx - 1]
            }
        }

        val dp = Array(nPadded) { IntArray(nPadded) { 0 } }
        for (len in 1..nNums) {
            for (lo in 1 until nPadded - len) {
                val hi = lo + len - 1
                var maxCoins = 0

                for (k in lo..hi) {
                    maxCoins = maxOf(
                        maxCoins, dp[lo][k - 1] + padded[lo - 1] * padded[k] * padded[hi + 1] + dp[k + 1][hi]
                    )
                }

                dp[lo][hi] = maxCoins
            }
        }

        return dp[1][nNums]
    }
}