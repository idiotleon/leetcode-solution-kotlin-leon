package com.idiotleon.leetcode.lvl2.lc0674

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/discuss/107365/JavaC%2B%2BClean-solution
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun findLengthOfLCIS(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val nNums = nums.size

        var longest = 1
        var len = 1

        for (i in 1 until nNums) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                longest = maxOf(longest, ++len)
            } else {
                len = 1
            }
        }

        return longest
    }
}