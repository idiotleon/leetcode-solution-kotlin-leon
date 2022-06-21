package com.an7one.leetcode.lvl2.lc0035

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/search-insert-position/
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun searchInsert(nums: IntArray, target: Int): Int {
        // sanity check
        if (nums.isEmpty())
            return 0

        val nNums = nums.size

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] < target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return lo
    }
}