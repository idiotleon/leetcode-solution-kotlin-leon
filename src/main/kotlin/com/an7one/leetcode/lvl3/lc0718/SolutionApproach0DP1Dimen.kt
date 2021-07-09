/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 *
 * Time Complexity:     O(`nNums1` * `nNums2`)
 * Space Complexity:    O(`nNums1`)
 */
package com.an7one.leetcode.lvl3.lc0718

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val nNums1 = nums1.size
        // not used
        // val nNums2 = nums2.size

        var longest = 0

        val dp = IntArray(nNums1 + 1) { 0 }
        for (idx1 in nums1.indices.reversed()) {
            for (idx2 in nums2.indices) {
                dp[idx2] = if (nums1[idx1] == nums2[idx2]) 1 + dp[1 + idx2] else 0
                longest = maxOf(longest, dp[idx2])
            }
        }

        return longest
    }
}