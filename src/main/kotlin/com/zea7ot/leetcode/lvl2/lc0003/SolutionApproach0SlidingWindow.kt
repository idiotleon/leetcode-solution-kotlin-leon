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
    fun lengthOfLongestSubstring(s: String): Int {
        var longest = 0
        // sanity check
        if (s.isEmpty()) return longest

        val lenS = s.length
        val freqs = IntArray(128) { 0 }

        var lo = 0
        var hi = 0

        while (hi < lenS) {
            ++freqs[s[hi].toInt()]

            while (freqs[s[hi].toInt()] > 1) {
                --freqs[s[lo].toInt()]
                ++lo
            }

            val len = hi - lo + 1
            longest = maxOf(longest, len)

            ++hi
        }

        return longest
    }
}