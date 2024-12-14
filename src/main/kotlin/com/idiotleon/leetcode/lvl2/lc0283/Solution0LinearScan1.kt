package com.idiotleon.leetcode.lvl2.lc0283

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/move-zeroes
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-so-8r3q/
 */
@Suppress(UNUSED)
class Solution0LinearScan1 {
    fun moveZeroes(nums: IntArray): Unit {
        val nNums = nums.size
        var zeroCount = 0
        for (idx in 0 until nNums) {
            if (nums[idx] == 0) {
                ++zeroCount
            } else if (zeroCount > 0) {
                val temp = nums[idx]
                nums[idx] = 0
                nums[idx - zeroCount] = temp
            }
        }
    }
}