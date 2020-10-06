/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0167

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val ans = IntArray(2)
        if (nums.isEmpty()) return ans

        val size = nums.size

        var lo = 0
        var hi = size - 1

        while (lo < hi) {
            val sum = nums[lo] + nums[hi]

            when {
                sum == target -> {
                    ans[0] = lo + 1
                    ans[1] = hi + 1
                    return ans
                }
                sum > target -> --hi
                else -> ++lo
            }
        }

        return ans
    }
}