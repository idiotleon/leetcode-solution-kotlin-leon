/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * ### TLEed ###
 *
 * References:
 *  https://leetcode.com/problems/partition-equal-subset-sum/discuss/462699/Whiteboard-Editorial.-All-Approaches-explained.
 */
package com.zea7ot.leetcode.lvl3.lc0416

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach2DFS {
    fun canPartition(nums: IntArray): Boolean {
        // not used
        // val totalNums = nums.size

        // this helps prevent TLE, but still gets it
        nums.sortDescending()

        val volume = nums.sum()
        if (volume % 2 == 1) return false

        val target = volume / 2

        return dfs(0, nums, target)
    }

    private fun dfs(idx: Int, nums: IntArray, target: Int): Boolean {
        val totalNums = nums.size
        if (target < 0 || idx >= totalNums) return false
        if (target == nums[idx]) return true

        return dfs(idx + 1, nums, target - nums[idx]) || dfs(idx + 1, nums, target)
    }
}