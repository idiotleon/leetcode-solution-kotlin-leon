package com.idiotleon.leetcode.lvl2.lc0003

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    fun lengthOfLongestSubstring(str: String): Int {
        val lenS = str.length

        var longest = 0
        if (str.isEmpty()) {
            return longest
        }

        val freqs = IntArray(128) { 0 }

        var lo = 0
        var hi = 0

        while (hi < lenS) {
            ++freqs[str[hi].code]

            while (freqs[str[hi].code] > 1) {
                --freqs[str[lo].code]
                ++lo
            }

            val len = hi - lo + 1
            longest = maxOf(longest, len)

            ++hi
        }

        return longest
    }
}