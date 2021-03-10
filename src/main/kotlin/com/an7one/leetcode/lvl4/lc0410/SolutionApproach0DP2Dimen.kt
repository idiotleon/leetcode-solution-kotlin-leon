/**
 * https://leetcode.com/problems/j-array-largest-sum/
 *
 * Time Complexity:     O(`totalNums` * `m` * `totalNums`)
 * Space Complexity:    O(`totalNums` * `m`)
 *
 * this approach applies to situations where there is are negative numbers
 *
 * References:
 *  https://youtu.be/FLbqgyJ-70I?t=6300
 */
package com.an7one.leetcode.lvl4.lc0410

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun splitArray(nums: IntArray, m: Int): Int {
        // sanity check, not required
        // if (nums.isEmpty()) return 0

        val totalNums = nums.size

        // 1-indexed, instead of 0-indexed
        val prefixSums = IntArray(totalNums + 1)
        for (i in 0 until totalNums) {
            prefixSums[i + 1] = prefixSums[i] + nums[i]
        }

        val dp = Array(totalNums + 1) { IntArray(m + 1) { Int.MAX_VALUE } }
        dp[0][0] = 0

        for (hi in 1..totalNums) {
            // the actual split(s), starting with 1
            for (partition in 1..m) {
                // [0, lo], [lo, hi]: where to split the array
                for (lo in 0 until hi) {
                    val subarraySum = prefixSums[hi] - prefixSums[lo]
                    dp[hi][partition] = minOf(dp[hi][partition], maxOf(dp[lo][partition - 1], subarraySum))
                }
            }
        }

        return dp[totalNums][m]
    }
}