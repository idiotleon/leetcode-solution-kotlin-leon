/**
 * https://leetcode.com/problems/house-robber/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(N) ~ O(N)
 *
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.an7one.leetcode.lvl2.lc0198

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun rob(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val size = nums.size
        val memo = IntArray(size + 1) { -1 }

        return dfs(size - 1, nums, memo)
    }

    private fun dfs(idx: Int, nums: IntArray, memo: IntArray): Int {
        if (idx < 0) return 0
        if (memo[idx] >= 0) return memo[idx]

        val res = maxOf(dfs(idx - 1, nums, memo), dfs(idx - 2, nums, memo) + nums[idx])
        memo[idx] = res
        return res
    }
}