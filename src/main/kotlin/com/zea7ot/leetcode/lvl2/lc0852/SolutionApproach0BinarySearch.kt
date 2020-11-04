/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139848/C%2B%2BJavaPython-Better-than-Binary-Search
 */
package com.zea7ot.leetcode.lvl2.lc0852

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun peakIndexInMountainArray(nums: IntArray): Int {
        val nNums = nums.size

        var lo = 1
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