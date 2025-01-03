package com.idiotleon.leetcode.lvl1.lc1822

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun arraySign(nums: IntArray): Int {
        val nNums = nums.size

        var ans = 1
        for (num in nums) {
            when {
                num > 0 -> ans *= 1
                num < 0 -> ans *= -1
                num == 0 -> return 0
            }
        }

        return ans
    }
}