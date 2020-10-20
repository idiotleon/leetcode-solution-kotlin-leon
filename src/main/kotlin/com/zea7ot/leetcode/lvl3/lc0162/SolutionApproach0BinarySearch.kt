/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * Time Complexity:     O(lg(`totalNums`))
 * Space Complexity:    O(lg(`totalNums`))
 *
 * References:
 *  https://zxi.mytechroad.com/blog/algorithms/binary-search/%E8%8A%B1%E8%8A%B1%E9%85%B1-leetcode-162-find-peak-element/
 */
package com.zea7ot.leetcode.lvl3.lc0162

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun findPeakElement(nums: IntArray): Int {
        val totalNums = nums.size

        var lo = 0
        var hi = totalNums - 1
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return lo
    }
}