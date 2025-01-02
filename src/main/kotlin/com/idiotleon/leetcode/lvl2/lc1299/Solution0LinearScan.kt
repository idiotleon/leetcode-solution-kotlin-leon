package com.idiotleon.leetcode.lvl2.lc1299

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun replaceElements(nums: IntArray): IntArray {
        val nNums = nums.size

        var curMax = -1
        for (idx in nNums - 1 downTo 0) {
            val hold = nums[idx]
            nums[idx] = curMax
            curMax = maxOf(curMax, hold)
        }

        return nums
    }
}