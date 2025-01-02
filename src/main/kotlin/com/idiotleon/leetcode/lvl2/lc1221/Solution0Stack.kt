package com.idiotleon.leetcode.lvl2.lc1221

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0Stack {
    private companion object {
        private const val LEFT = 'L'
        private const val RIGHT = 'R'
    }

    fun balancedStringSplit(s: String): Int {
        val lenS = s.length

        var stack = 0
        var count = 0
        for (ch in s) {
            when (ch) {
                LEFT -> ++stack
                RIGHT -> --stack
                else -> {}
            }
            if (stack == 0) {
                ++count
            }
        }

        return count
    }
}