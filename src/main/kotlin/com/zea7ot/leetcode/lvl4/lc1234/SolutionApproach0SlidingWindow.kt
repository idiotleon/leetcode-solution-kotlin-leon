/**
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(4) / O(L) ~ O(1) / O(L)
 *
 * `freq[]` keeps accounts of the frequencies OUTSIDE the sliding window
 *
 * References:
 *  https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC%2B%2BPython-Sliding-Window
 */
package com.zea7ot.leetcode.lvl4.lc1234

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

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

        val k = lenS / 4
        if (isValid(freqs, k)) return 0

        var lo = 0
        var hi = 0
        var shortest = lenS

        while (hi < lenS) {
            --freqs[s[hi] - 'A']

            while (isValid(freqs, k)) {
                shortest = minOf(shortest, hi - lo + 1)
                ++freqs[s[lo] - 'A']
                ++lo
            }

            ++hi
        }

        return shortest
    }

    private fun isValid(freqs: IntArray, k: Int): Boolean {
        for (freq in freqs) {
            if (freq > k) return false
        }

        return true
    }
}