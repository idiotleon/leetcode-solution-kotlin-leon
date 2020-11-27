/**
 * @author: Leon
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0003

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun lengthOfLongestSubstring(str: String): Int {
        var longest = 0
        // sanity check
        if (str.isEmpty()) return longest

        val lenS = str.length
        val freqs = IntArray(128) { 0 }

        var lo = 0
        var hi = 0

        while (hi < lenS) {
            ++freqs[str[hi].toInt()]

            while (freqs[str[hi].toInt()] > 1) {
                --freqs[str[lo].toInt()]
                ++lo
            }

            val len = hi - lo + 1
            longest = maxOf(longest, len)

            ++hi
        }

        return longest
    }
}