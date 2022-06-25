package com.an7one.leetcode.lvl3.lc0665

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/non-decreasing-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 * https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC++-Simple-greedy-like-solution-with-explanation/241578
 * https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC++-Simple-greedy-like-solution-with-explanation/109180
 * https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC%2B%2B-Simple-greedy-like-solution-with-explanation
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun checkPossibility(nums: IntArray): Boolean {
        val nNums = nums.size

        var modified = 0

        for (i in 1 until nNums) {
            if (nums[i - 1] > nums[i]) {
                if (++modified > 1) return false
                if (i == 1 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i]
                else nums[i] = nums[i - 1]
            }
        }

        return true
    }
}