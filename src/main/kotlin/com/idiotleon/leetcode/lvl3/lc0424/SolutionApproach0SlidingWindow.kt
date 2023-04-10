package com.idiotleon.leetcode.lvl3.lc0424

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1)
 *
 * Reference:
 * https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation/95833
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun characterReplacement(s: String, k: Int): Int {
        // sanity check
        if (s.isEmpty()) return 0

        val lenS = s.length

        val freqs = IntArray(26)
        var maxCount = 0

        var lo = 0
        var hi = 0

        while (hi < lenS) {
            maxCount = maxOf(maxCount, ++freqs[s[hi] - 'A'])

            val len = hi - lo + 1
            if (maxCount + k < len) --freqs[s[lo++] - 'A']

            ++hi
        }

        return lenS - lo
    }
}