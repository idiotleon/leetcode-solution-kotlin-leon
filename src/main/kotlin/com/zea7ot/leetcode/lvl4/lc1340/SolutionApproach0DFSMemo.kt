/**
 * https://leetcode.com/problems/jump-game-v/
 *
 * Time Complexity:     O(`totalNums` * `d`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/jump-game-v/discuss/496520/Top-Down-DP-O(nd)/442759
 *  https://leetcode.com/problems/jump-game-v/discuss/496520/Top-Down-DP-O(nd)
 */
package com.zea7ot.leetcode.lvl4.lc1340

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun maxJumps(nums: IntArray, d: Int): Int {
        val totalNums = nums.size
        val memo = IntArray(totalNums) { 0 }

        var most = 1
        for (idx in nums.indices) {
            most = maxOf(most, dfs(idx, nums, d, memo))
        }

        return most
    }

    private fun dfs(cur: Int, nums: IntArray, d: Int, memo: IntArray): Int {
        val totalNums = nums.size
        if (memo[cur] != 0) return memo[cur]

        var most = 1
        for (hiNext in cur + 1..minOf(cur + d, totalNums - 1)) {
            if (nums[hiNext] >= nums[cur]) break
            most = maxOf(most, 1 + dfs(hiNext, nums, d, memo))
        }

        for (loNext in cur - 1 downTo maxOf(cur - d, 0)) {
            if (nums[loNext] >= nums[cur]) break
            most = maxOf(most, 1 + dfs(loNext, nums, d, memo))
        }

        memo[cur] = most
        return most
    }
}