package com.idiotleon.leetcode.lvl1.lc3151

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/special-array-i/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun isArraySpecial(nums: IntArray): Boolean {
        val nNums = nums.size

        for (idx in 0 until nNums - 1) {
            val cur = nums[idx]
            val next = nums[idx + 1]

            if (getParity(cur) == getParity(next)) {
                return false
            }
        }

        return true
    }

    private fun getParity(num: Int): Int = num % 2
}