package com.idiotleon.leetcode.lvl2.lc0026

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0HighLowPointers {
    fun removeDuplicates(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty())
            return 0

        val nNums = nums.size

        var lo = 1
        var hi = 1

        while (hi < nNums) {
            while (hi < nNums && nums[hi - 1] == nums[hi]) {
                ++hi
            }

            if (hi == nNums) break
            nums[lo] = nums[hi]
            ++lo
            ++hi
        }

        return lo
    }
}