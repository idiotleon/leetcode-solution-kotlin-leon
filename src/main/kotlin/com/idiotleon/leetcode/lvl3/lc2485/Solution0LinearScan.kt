package com.idiotleon.leetcode.lvl3.lc2485

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-pivot-integer/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun pivotInteger(n: Int): Int {
        for (num in 1..n) {
            val loSum = (1 + num) * (num - 1 + 1) / 2
            val hiSum = (num + n) * (n - num + 1) / 2
            if (loSum == hiSum) {
                return num
            }
        }

        return -1
    }
}