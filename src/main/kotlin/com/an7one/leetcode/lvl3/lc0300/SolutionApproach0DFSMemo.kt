/**
 * https://leetcode.com/problems/longest-increasing-subsequence
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
 *  https://youtu.be/7DKFpWnaxLI
 */
package com.an7one.leetcode.lvl3.lc0300

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun lengthOfLIS(nums: IntArray): Int {
        // sanity check, required
        if (nums.isEmpty()) return 0

        val nNums = nums.size

        var longest = 1

        // memoization
        // index to (longest) length
        val idxToLen = Array<Int?>(nNums) { null }

        for (hi in nums.indices) {
            for (lo in 0 until hi) {
                if (nums[hi] > nums[lo]) {
                    longest = maxOf(longest, dfs(hi, nums, idxToLen))
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
            if (nums[lo] < nums[idx]) {
                longest = maxOf(longest, 1 + dfs(lo, nums, memo))
            }
        }

        memo[idx] = longest
        return longest
    }
}