/**
 * https://leetcode.com/problems/j-array-largest-sum/
 *
 * Time Complexity:     O(`size` * `m` * `size`)
 * Space Complexity:    O(`size` * `m`)
 *
 * this approach applies to situations where there is are negative numbers
 *
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=6300
 */
package com.zea7ot.lc.lvl4.lc0410

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun splitArray(nums: IntArray, m: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val size = nums.size

        // 1-indexed, instead of 0-indexed
        val prefixSums = IntArray(size + 1)
        for (i in 0 until size) {
            prefixSums[i + 1] = prefixSums[i] + nums[i]
        }

        val dp = Array(size + 1) { IntArray(m + 1) { Int.MAX_VALUE } }
        dp[0][0] = 0

        // 1-indexed, instead of 0-indexed
        for (i in 1..size) {
            // the actual split(s), starting with 1
            for (j in 1..m) {
                // [0, k], [k, i]: where to split the array
                for (k in 0 until i) {
                    val subarraySum = prefixSums[i] - prefixSums[k]
                    dp[i][j] = minOf(dp[i][j], maxOf(dp[k][j - 1], subarraySum))
                }
            }
        }

        return dp[size][m]
    }
}