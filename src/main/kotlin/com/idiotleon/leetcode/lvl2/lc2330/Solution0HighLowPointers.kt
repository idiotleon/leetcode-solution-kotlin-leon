package com.idiotleon.leetcode.lvl2.lc2330

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/valid-palindrome-iv/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/valid-palindrome-iv/solutions/2247439/python3-simple-ac-two-pointers-solution/
 */
@Suppress(UNUSED)
class Solution0HighLowPointers {
    fun makePalindrome(s: String): Boolean {
        val lenS = s.length

        var lo = 0
        var hi = lenS - 1

        var count = 0
        while (lo < hi) {
            if (s[lo] != s[hi]) {
                ++count
                if (count > 2) {
                    return false
                }
            }

            ++lo
            --hi
        }

        return true
    }
}