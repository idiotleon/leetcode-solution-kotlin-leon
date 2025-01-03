package com.idiotleon.leetcode.lvl1.lc2595

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-even-and-odd-bits/
 *
 * Time Complexity:     O(lg(`n`)) ~ O(1)
 * Space Complexity:    O(10
 */
@Suppress(UNUSED)
class Solution0Math {
    fun evenOddBit(n: Int): IntArray {
        var countEven = 0
        var countOdd = 0

        var num = n
        var step = 0
        while (num > 0) {
            val mod = num % 2

            if (mod == 1) {
                if (step % 2 == 0) {
                    ++countEven
                } else {
                    ++countOdd
                }
            }

            num /= 2
            ++step
        }

        return intArrayOf(countEven, countOdd)
    }
}