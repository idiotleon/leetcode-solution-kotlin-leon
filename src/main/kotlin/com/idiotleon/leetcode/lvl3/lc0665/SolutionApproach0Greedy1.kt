package com.idiotleon.leetcode.lvl3.lc0665

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/non-decreasing-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 * https://leetcode.com/problems/non-decreasing-array/discuss/106849/C%2B%2B-Java-Clean-Code-6-liner-Without-Modifying-Input
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun checkPossibility(nums: IntArray): Boolean {
        val nNums = nums.size

        var modified = 0
        var prev = nums[0]

        for (i in 1 until nNums) {
            if (prev > nums[i]) {
                if (++modified > 1) return false

                if (i - 2 >= 0 && nums[i - 2] > nums[i]) continue
            }

            prev = nums[i]
        }

        return true
    }
}