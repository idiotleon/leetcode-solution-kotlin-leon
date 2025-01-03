package com.idiotleon.leetcode.lvl1.lc1903

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/largest-odd-number-in-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0ParseString {
    fun largestOddNumber(s: String): String {
        val lenS = s.length

        for (idx in lenS - 1 downTo 0) {
            val digit = s[idx] - '0'
            if (digit % 2 == 1) {
                return s.substring(0, idx + 1)
            }
        }

        return ""
    }
}