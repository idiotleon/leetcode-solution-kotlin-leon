/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0217

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sort {
    fun containsDuplicate(nums: IntArray): Boolean {
        val nNums = nums.size
        nums.sort()

        for (idx in 1 until nNums) {
            if (nums[idx - 1] == nums[idx]) {
                return true
            }
        }

        return false
    }
}