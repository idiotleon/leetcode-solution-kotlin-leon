/**
 * https://leetcode.com/problems/j-array-largest-sum/
 *
 * Time Complexity:     O(`nNums` * `m` * `nNums`)
 * Space Complexity:    O(`nNums` * `m`)
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

        val nNums = nums.size

        val prefixSums = IntArray(nNums + 1) { 0 }
        for ((idx, num) in nums.withIndex()) {
            prefixSums[idx + 1] = prefixSums[idx] + num
        }

        val dp = Array(nNums + 1) { IntArray(m + 1) { Int.MAX_VALUE } }.also {
            it[0][0] = 0
        }

        for (hi in 1..nNums) {
            // the actual split(s), starting with 1
            for (par in 1..m) {
                // [0, lo], [lo, hi]: where to split the array
                for (lo in 0 until hi) {
                    val sumSubarray = prefixSums[hi] - prefixSums[lo]
                    dp[hi][par] = minOf(dp[hi][par], maxOf(dp[lo][par - 1], sumSubarray))
                }
            }
        }

        return dp[nNums][m]
    }
}