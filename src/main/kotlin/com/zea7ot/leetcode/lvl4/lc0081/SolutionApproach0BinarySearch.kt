/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Time Complexity:     O(lg(`nNums`)), O(`nNums`) in the worst case
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search/27196
 *  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search
 */
package com.zea7ot.leetcode.lvl4.lc0081

class SolutionApproach0BinarySearch {
    fun search(nums: IntArray, target: Int): Boolean {
        val nNums = nums.size

        var lo = 0
        var hi = nNums - 1

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2

            if (nums[mid] == target) return true

            if (nums[lo] < nums[mid]) {
                if (target in nums[lo]..nums[mid]) {
                    hi = mid - 1
                } else {
                    lo = mid + 1
                }
            } else if (nums[lo] > nums[mid]) {
                if (target in nums[mid]..nums[hi]) {
                    lo = mid + 1
                } else {
                    hi = mid - 1
                }
            } else {
                ++lo
            }
        }

        return false
    }
}