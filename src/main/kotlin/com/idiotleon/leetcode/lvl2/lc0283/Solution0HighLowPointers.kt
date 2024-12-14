package com.idiotleon.leetcode.lvl2.lc0283

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/move-zeroes/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-solution-beats-100-o-n-clear-explanation/
 */
@Suppress(UNUSED)
class Solution0HighLowPointers {
    fun moveZeroes(nums: IntArray): Unit {
        val nNums = nums.size
        var lo = 0
        for (hi in 0 until nNums) {
            if (nums[hi] != 0 && nums[lo] == 0) {
                val temp = nums[hi]
                nums[hi] = nums[lo]
                nums[lo] = temp
            }
            if (nums[lo] != 0) {
                ++lo
            }
        }
    }
}