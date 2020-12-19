/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * Time Complexity:     O(lg(`totalNums`))
 * Space Complexity:    O(lg(`totalNums`))
 *
 * References:
 *  https://zxi.mytechroad.com/blog/algorithms/binary-search/%E8%8A%B1%E8%8A%B1%E9%85%B1-leetcode-162-find-peak-element/
 */
package com.zea7ot.leetcode.lvl4.lc0162

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun findPeakElement(nums: IntArray): Int {
        val nNums = nums.size

        var lo = 0
        var hi = nNums - 1
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