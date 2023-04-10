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
 * https://youtu.be/Dxv_kCAYOk4
 * https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC++-Simple-greedy-like-solution-with-explanation/109180
 * https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC%2B%2B-Simple-greedy-like-solution-with-explanation
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy2 {
    fun checkPossibility(nums: IntArray): Boolean {
        val nNums = nums.size

        var modified = 0

        for (i in 1 until nNums) {
            if (nums[i - 1] > nums[i]) {
                if (i == 1 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i]
                    ++modified
                } else {
                    nums[i] = nums[i - 1]
                    ++modified
                }
            }
        }

        return modified <= 1
    }
}