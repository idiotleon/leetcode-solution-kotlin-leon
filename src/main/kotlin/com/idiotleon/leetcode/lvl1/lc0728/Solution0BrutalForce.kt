package com.idiotleon.leetcode.lvl1.lc0728

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/self-dividing-numbers/
 *
 * Time Complexity:     O(`right` - `left`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0BrutalForce {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val ans = mutableListOf<Int>()

        for (num in left..right) {
            if (isSelfDividing(num)) {
                ans.add(num)
            }
        }

        return ans
    }

    private fun isSelfDividing(num: Int): Boolean {
        var digits = num
        while (digits > 0) {
            val digit = digits % 10
            if (digit == 0 || num % digit != 0) {
                return false
            }
            digits /= 10
        }

        return true
    }
}