/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
 * Time Complexity:     O(lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/discuss/451286/Java-Binary-Search
 */
package com.an7one.leetcode.lvl3.lc1287

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun findSpecialInteger(nums: IntArray): Int {
        val nNums = nums.size
        if (nNums == 1) return nums[0]

        val candidates = listOf(nums[nNums / 4], nums[nNums / 2], nums[(3 * nNums) / 4])
        for (num in candidates) {
            val idx = lowerBound(num, nums)
            if (nums[idx + nNums / 4] == num) {
                return num
            }
        }

        return -1
    }

    private fun lowerBound(target: Int, nums: IntArray): Int {
        val nNums = nums.size

        var lo = 0
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (target <= nums[mid]) {
                hi = mid
            } else {
                lo = 1 + mid
            }
        }

        return lo
    }
}