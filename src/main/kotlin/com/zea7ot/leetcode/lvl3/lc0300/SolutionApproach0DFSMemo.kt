/**
 * https://leetcode.com/problems/longest-increasing-subsequence
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
 *  https://youtu.be/7DKFpWnaxLI
 */
package com.zea7ot.leetcode.lvl3.lc0300

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun lengthOfLIS(nums: IntArray): Int {
        // sanity check, required
        if (nums.isEmpty()) return 0

        val totalNums = nums.size

        var longest = 1
        val memo = Array<Int?>(totalNums) { null }

        for (hi in nums.indices) {
            for (lo in 0 until hi) {
                if (nums[hi] > nums[lo]) {
                    longest = maxOf(longest, dfs(hi, nums, memo))
                }
            }
        }

        return longest
    }

    private fun dfs(idx: Int, nums: IntArray, memo: Array<Int?>): Int {
        if (idx == 0) return 1

        memo[idx]?.let { return it }

        var longest = 1
        for (lo in 0 until idx) {
            if (nums[idx] > nums[lo]) {
                longest = maxOf(longest, 1 + dfs(lo, nums, memo))
            }
        }

        memo[idx] = longest
        return longest
    }
}