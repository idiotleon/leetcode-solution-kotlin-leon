package com.an7one.leetcode.lvl4.lc0330

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/patching-array/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/patching-array/discuss/78492/C%2B%2B-8ms-greedy-solution-with-explanation
 * https://leetcode.com/problems/patching-array/discuss/280183/Detailed-Explanation-with-Example
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun minPatches(nums: IntArray, n: Int): Int {
        val nNums = nums.size

        // the largest number that currently can be achieved
        var patch = 0L
        var count = 0
        var idx = 0

        while (patch < n) {
            if (idx < nNums && patch + 1 >= nums[idx]) {
                patch += nums[idx].toLong()
                ++idx
            } else {
                patch += (patch + 1)
                ++count
            }
        }

        return count
    }
}