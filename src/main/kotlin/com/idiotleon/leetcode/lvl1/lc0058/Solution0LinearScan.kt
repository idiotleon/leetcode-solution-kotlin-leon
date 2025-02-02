package com.idiotleon.leetcode.lvl1.lc0058

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/length-of-last-word/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    private companion object {
        private const val SPACE = ' '
    }

    fun lengthOfLastWord(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        val lenS = s.length
        var hi = lenS - 1

        while (hi >= 0 && s[hi] == SPACE) {
            --hi
        }

        var len = 0
        while (hi >= 0 && s[hi] != SPACE) {
            --hi
            ++len
        }

        return len
    }
}