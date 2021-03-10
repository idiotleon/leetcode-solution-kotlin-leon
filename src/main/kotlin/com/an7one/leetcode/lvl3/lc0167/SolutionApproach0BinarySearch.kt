/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(N)
 */
package com.an7one.leetcode.lvl3.lc0167

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val nNums = nums.size

        var lo = 0
        var hi = nNums - 1

        while (lo < hi) {
            val sum = nums[lo] + nums[hi]

            when {
                sum < target -> ++lo
                sum > target -> --hi
                else -> return intArrayOf(lo + 1, hi + 1)
            }
        }

        return intArrayOf()
    }
}