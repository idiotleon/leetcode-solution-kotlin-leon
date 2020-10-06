/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0026

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HighLowPointers {
    fun removeDuplicates(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val sizeN = nums.size

        var lo = 1
        var hi = 1

        while (hi < sizeN) {
            while (hi < sizeN && nums[hi - 1] == nums[hi]) ++hi

            if (hi == sizeN) break
            nums[lo] = nums[hi]
            ++lo
            ++hi
        }

        return lo
    }
}