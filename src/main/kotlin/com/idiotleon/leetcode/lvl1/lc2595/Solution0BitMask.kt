package com.idiotleon.leetcode.lvl1.lc2595

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-even-and-odd-bits/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0BitMask {
    fun evenOddBit(n: Int): IntArray {
        var countOdd = 0
        var countEven = 0

        for (shift in 0 until 32) {
            val bitMask = 1 shl shift
            if ((bitMask and n) > 0) {
                if (shift % 2 == 0) {
                    ++countEven
                } else {
                    ++countOdd
                }
            }
        }

        return intArrayOf(countEven, countOdd)
    }
}