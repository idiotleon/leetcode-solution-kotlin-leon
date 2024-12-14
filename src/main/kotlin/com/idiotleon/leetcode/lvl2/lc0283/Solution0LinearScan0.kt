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
 * https://leetcode.com/problems/move-zeroes/solutions/72011/simple-on-java-solution-using-insert-ind-u41k/
 */
@Suppress(UNUSED)
class Solution0LinearScan0 {
    fun moveZeroes(nums: IntArray): Unit {
        val nNums = nums.size
        var idx = 0

        for (num in nums) {
            if (num != 0) {
                nums[idx] = num
                ++idx
            }
        }

        while (idx < nNums) {
            nums[idx] = 0
            ++idx
        }
    }
}