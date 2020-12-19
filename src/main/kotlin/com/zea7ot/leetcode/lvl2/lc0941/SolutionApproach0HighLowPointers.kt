/**
 * https://leetcode.com/problems/valid-mountain-array/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/valid-mountain-array/discuss/194900/C%2B%2BJavaPython-Climb-Mountain
 */
package com.zea7ot.leetcode.lvl2.lc0941

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HighLowPointers {
    fun validMountainArray(nums: IntArray): Boolean {
        val totalNums = nums.size
        var lo = 0
        var hi = totalNums - 1

        while (lo + 1 < totalNums && nums[lo] < nums[lo + 1]) ++lo
        while (hi > 0 && nums[hi - 1] > nums[hi]) --hi
        return lo > 0 && lo == hi && hi < totalNums - 1
    }
}