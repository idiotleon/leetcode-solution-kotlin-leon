package com.idiotleon.leetcode.lvl1.lc0258

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/add-digits
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0BrutalForce {
    fun addDigits(num: Int): Int {
        var num = num
        var res = 0

        while (num > 0) {
            val digit = num % 10
            res += digit
            num /= 10

            if (num == 0 && res > 9) {
                num = res
                res = 0
            }
        }

        return res
    }
}