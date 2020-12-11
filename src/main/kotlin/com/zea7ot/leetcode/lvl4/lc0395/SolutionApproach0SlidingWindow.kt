/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * Time Complexity:     O(26 * 26 * L) ~ O(L)
 * Space Complexity:    O(1) / O(L) + O(26) ~ O(1) / O(L)
 *
 * References:
 *  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/87739/Java-Strict-O(N)-Two-Pointer-Solution/188126
 *  https://www.cnblogs.com/grandyang/p/5852352.html
 */
package com.zea7ot.leetcode.lvl4.lc0395

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun longestSubstring(str: String, k: Int): Int {
        val lenS = str.length
        if (k < 2) return lenS

        var longest = 0
        for (allowed in 1..26) {
            val freqs = IntArray(26) { 0 }

            var lo = 0
            var hi = 0
            var distinct = 0

            while (hi < lenS) {
                if (freqs[str[hi] - 'a']++ == 0) ++distinct

                while (distinct > allowed) {
                    if (--freqs[str[lo++] - 'a'] == 0) --distinct
                }

                if (isValid(freqs, k)) {
                    longest = maxOf(longest, hi - lo + 1)
                }

                ++hi
            }
        }

        return longest
    }

    private fun isValid(freqs: IntArray, repeat: Int): Boolean {
        for (freq in freqs) {
            if (freq in 1 until repeat) {
                return false
            }
        }

        return true
    }
}