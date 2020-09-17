/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl2.lc0035

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun searchInsert(nums: IntArray, target: Int): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val sizeN = nums.size

        var lo = 0
        var hi = sizeN

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