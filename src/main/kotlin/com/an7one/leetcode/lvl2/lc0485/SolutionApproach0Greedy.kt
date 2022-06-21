package com.an7one.leetcode.lvl2.lc0485

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        // not used
        // val totalNums = nums.size

        var longest = 0
        var len = 0

        for (num in nums) {
            if (num == 0) {
                len = 0
            } else {
                longest = maxOf(longest, ++len)
            }
        }

        return longest
    }
}