package com.an7one.leetcode.lvl3.lc0055

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/jump-game/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun canJump(nums: IntArray): Boolean {
        val nNums = nums.size
        var furthest = 0

        for (i in 0 until nNums) {
            if (i > furthest) {
                return false
            }

            furthest = maxOf(furthest, i + nums[i])
            // pruning here
            if (furthest >= nNums) return true
        }

        return true
    }
}