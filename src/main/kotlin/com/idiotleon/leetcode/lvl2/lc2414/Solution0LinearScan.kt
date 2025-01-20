package com.idiotleon.leetcode.lvl2.lc2414

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun longestContinuousSubstring(s: String): Int {
        val lenS = s.length

        var len = 1
        var longest = 1
        var idx = 1
        while (idx < lenS) {
            if (s[idx] - s[idx - 1] == 1) {
                longest = maxOf(longest, ++len)
            } else {
                len = 1
            }
            ++idx
        }

        return longest
    }
}