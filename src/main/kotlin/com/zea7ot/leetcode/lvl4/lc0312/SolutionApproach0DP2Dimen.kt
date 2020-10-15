/**
 * https://leetcode.com/problems/burst-balloons/
 *
 * Time Complexity:     ?O(`totalNums` * `totalNums` * `totalNums`)
 * Space Complexity:    O(`totalNums` * `totalNums`)
 *
 * `dp[i][k]`, the maximum score with s[i : j] balloons burst
 *
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-312-burst-balloons/
 *  https://www.youtube.com/watch?v=z3hu2Be92UA
 *  https://youtu.be/FLbqgyJ-70I?t=7040
 */
package com.zea7ot.leetcode.lvl4.lc0312

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maxCoins(nums: IntArray): Int {
        val totalNums = nums.size

        // to pad both ends of `nums` array with 1s
        val padded = IntArray(totalNums + 2) { idx ->
            when (idx) {
                0 -> 1;
                totalNums + 1 -> 1;
                else -> nums[idx - 1]
            }
        }


        val dp = Array(totalNums + 2) { IntArray(totalNums + 2) { 0 } }
        for (len in 1..totalNums) {
            var i = 1
            while (i + len <= totalNums + 1) {
                val j = i + len - 1
                var best = 0
                for (k in i..j) {
                    best = maxOf(best,
                            dp[i][k - 1] + padded[i - 1] * padded[k] * padded[j + 1] + dp[k + 1][j])
                }

                dp[i][j] = best

                ++i
            }
        }

        return dp[1][totalNums]
    }
}