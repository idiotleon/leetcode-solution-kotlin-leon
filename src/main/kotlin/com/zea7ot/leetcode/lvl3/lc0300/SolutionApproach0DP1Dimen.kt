/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/longest-increasing-subsequence/discuss/74836/My-easy-to-understand-O(n2)-solution-using-DP-with-video-explanation/144619
 *  https://youtu.be/7DKFpWnaxLI
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
 */
package com.zea7ot.leetcode.lvl3.lc0300

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun lengthOfLIS(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val totalNums = nums.size

        val dp = IntArray(totalNums) { 1 }
        var longest = 1

        for (hi in nums.indices) {
            for (lo in 0 until hi) {
                if (nums[hi] > nums[lo]) {
                    dp[hi] = maxOf(dp[hi], dp[lo] + 1)
                }
            }

            longest = maxOf(longest, dp[hi])
        }

        return longest
    }
}