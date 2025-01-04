package com.idiotleon.leetcode.lvl2.lc2231

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0ParseInteger {
    fun largestInteger(num: Int): Int {
        val str = num.toString()
        val lenS = str.length
        val chs = str.toCharArray()
        for (lo in 0 until lenS - 1) {
            for (hi in lo + 1 until lenS) {
                if (chs[hi] > chs[lo] && (chs[hi] - chs[lo]) % 2 == 0) {
                    val temp = chs[lo]
                    chs[lo] = chs[hi]
                    chs[hi] = temp
                }
            }
        }

        return String(chs).toInt()
    }
}