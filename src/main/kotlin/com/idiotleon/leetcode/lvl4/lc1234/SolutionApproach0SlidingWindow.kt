package com.idiotleon.leetcode.lvl4.lc1234

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(4) / O(`lenS`) ~ O(1) / O(`lenS`)
 *
 * `freq[]` keeps accounts of the frequencies OUTSIDE the sliding window
 *
 * References:
 *  https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC%2B%2BPython-Sliding-Window
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun balancedString(s: String): Int {
        // sanity check
        if (s.isEmpty()) return 0

        val lenS = s.length
        val freqs = IntArray(26)
        for (ch in s) {
            ++freqs[ch - 'A']
        }

        val freqExpected = lenS / 4
        if (isValid(freqs, freqExpected)) return 0

        var lo = 0
        var hi = 0
        var shortest = lenS

        while (hi < lenS) {
            --freqs[s[hi] - 'A']

            while (isValid(freqs, freqExpected)) {
                val len = hi - lo + 1
                shortest = minOf(shortest, len)
                ++freqs[s[lo] - 'A']
                ++lo
            }

            ++hi
        }

        return shortest
    }

    private fun isValid(freqs: IntArray, freqExpected: Int): Boolean {
        for (freq in freqs) {
            if (freq > freqExpected) return false
        }

        return true
    }
}