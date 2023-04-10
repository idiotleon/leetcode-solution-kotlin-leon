package com.idiotleon.leetcode.lvl3.lc0300

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/longest-increasing-subsequence/discuss/74836/My-easy-to-understand-O(n2)-solution-using-DP-with-video-explanation/144619
 * https://youtu.be/7DKFpWnaxLI
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun lengthOfLIS(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val nNums = nums.size

        val dp = IntArray(nNums) { 1 }
        var longest = 1

        for (hi in nums.indices) {
            for (lo in 0 until hi) {
                if (nums[lo] < nums[hi]) {
                    dp[hi] = maxOf(dp[hi], 1 + dp[lo])
                }
            }

            longest = maxOf(longest, dp[hi])
        }

        return longest
    }
}