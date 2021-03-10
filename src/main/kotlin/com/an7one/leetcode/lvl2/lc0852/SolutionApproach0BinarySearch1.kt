/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139848/C%2B%2BJavaPython-Better-than-Binary-Search
 */
package com.an7one.leetcode.lvl2.lc0852

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch1 {
    fun peakIndexInMountainArray(nums: IntArray): Int {
        val nNums = nums.size

        var lo = 1
        var hi = nNums - 1
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid
            } else if (nums[mid - 1] > nums[mid]) {
                hi = mid - 1
            } else {
                lo = mid + 1
            }
        }

        return lo
    }
}