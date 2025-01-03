package com.idiotleon.leetcode.lvl2.lc1427

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/perform-string-shifts/
 *
 * Time Complexity:     O('lenS')
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    private companion object {
        private const val LEFT = 0
        private const val RIGHT = 1
    }

    fun stringShift(s: String, shifts: Array<IntArray>): String {
        val lenS = s.length
        var totalShift = 0
        for ((direction, shift) in shifts) {
            when (direction) {
                LEFT -> {
                    totalShift -= shift
                }

                RIGHT -> {
                    totalShift += shift
                }

                else -> {}
            }
        }

        totalShift %= lenS
        return if (totalShift > 0) {
            s.substring(lenS - totalShift) + s.substring(0, lenS - totalShift)
        } else {
            s.substring(abs(totalShift)) + s.substring(0, abs(totalShift))
        }
    }
}