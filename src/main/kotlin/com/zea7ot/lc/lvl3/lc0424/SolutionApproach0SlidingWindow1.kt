/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1)
 *
 * References:
 *  https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
 */
package com.zea7ot.lc.lvl3.lc0424

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow1 {
    fun characterReplacement(s: String, k: Int): Int {
        // sanity check
        if (s.isEmpty()) return 0

        val lenS = s.length

        val freqs = IntArray(26)
        var maxCount = 0
        var longest = 0

        var lo = 0
        var hi = 0

        while (hi < lenS) {
            maxCount = maxOf(maxCount, ++freqs[s[hi] - 'A'])

            val len = hi - lo + 1
            if (maxCount + k >= len) {
                longest = maxOf(longest, len)
            } else {
                --freqs[s[lo] - 'A']
                ++lo
            }

            ++hi
        }

        return longest
    }
}