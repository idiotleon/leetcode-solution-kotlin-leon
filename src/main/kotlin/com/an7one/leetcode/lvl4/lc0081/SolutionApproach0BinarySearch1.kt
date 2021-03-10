/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Time Complexity:     O(lg(`nNums`)), O(`nNums`) in the worst case
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28218/My-8ms-C++-solution-(o(logn)-on-average-o(n)-worst-case)/284690
 *  https://github.com/wind-liang/leetcode/blob/master/leetCode-81-Search-in-Rotated-Sorted-ArrayII.md
 *  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28218/My-8ms-C++-solution-(o(logn)-on-average-o(n)-worst-case)/666600
 */
package com.an7one.leetcode.lvl4.lc0081

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch1 {
    fun search(nums: IntArray, target: Int): Boolean {
        val nNums = nums.size

        var lo = 0
        var hi = nNums - 1

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] == target) return true
            if (nums[lo] < nums[mid]) {
                if (target in nums[lo] until nums[mid]) {
                    hi = mid - 1
                } else {
                    lo = mid + 1
                }
            } else if (nums[lo] == nums[mid]) {
                ++lo
            } else {
                if (target in nums[mid]..nums[hi]) {
                    lo = mid + 1
                } else {
                    hi = mid - 1
                }
            }
        }

        return false
    }
}