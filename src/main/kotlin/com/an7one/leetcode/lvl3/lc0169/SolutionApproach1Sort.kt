package com.an7one.leetcode.lvl3.lc0169

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/majority-element/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://youtu.be/SWr4cSY2fCk?t=580s
 */
@Suppress(UNUSED)
class SolutionApproach1Sort {
    fun majorityElement(nums: IntArray): Int {
        val nNums = nums.size
        nums.sort()
        return nums[nNums / 2]
    }
}