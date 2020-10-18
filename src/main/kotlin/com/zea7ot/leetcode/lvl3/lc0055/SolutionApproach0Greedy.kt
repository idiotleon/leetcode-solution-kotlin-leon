/**
 * https://leetcode.com/problems/jump-game/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0055

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun canJump(nums: IntArray): Boolean {
        val totalNums = nums.size
        var furthest = 0

        for (i in 0 until totalNums) {
            if (i > furthest) {
                return false
            }

            furthest = maxOf(furthest, i + nums[i])
            // pruning here
            if (furthest >= totalNums) return true
        }

        return true
    }
}