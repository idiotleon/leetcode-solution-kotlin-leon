/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 *
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2)
 *
 * dp[i][j] represents the longest fibonacci subsequence ending with `nums[i]` and `nums[j]`
 * dp[i][j] = (dp[j - i][i] + 1) or 2
 *
 * References:
 *  https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/165330/Java-beat-98-DP-%2B-2Sum
 */
package com.zea7ot.lc.lvl3.lc0873

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun lenLongestFibSubseq(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val totalSize = nums.size

        val dp = Array(totalSize) { IntArray(totalSize) { 0 } }
        var longest = 0

        for (i in 2 until totalSize) {
            val target = nums[i]

            var lo = 0
            var hi = i - 1

            while (lo < hi) {
                val sum = nums[lo] + nums[hi]
                when {
                    sum > target -> --hi
                    sum < target -> ++lo
                    else -> {
                        dp[hi][i] = dp[lo][hi] + 1
                        longest = maxOf(longest, dp[hi][i])
                        --hi
                        ++lo
                    }
                }
            }
        }

        if (longest > 0) longest += 2

        return longest
    }
}