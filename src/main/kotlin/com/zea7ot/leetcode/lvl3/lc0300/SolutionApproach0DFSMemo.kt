package com.zea7ot.leetcode.lvl3.lc0300

class SolutionApproach0DFSMemo {
    fun lengthOfLIS(nums: IntArray): Int {
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
        val hi = idx
        for (lo in 0 until hi) {
            if (nums[hi] > nums[lo]) {
                longest = maxOf(longest, 1 + dfs(lo, nums, memo))
            }
        }

        memo[idx] = longest
        return longest
    }
}