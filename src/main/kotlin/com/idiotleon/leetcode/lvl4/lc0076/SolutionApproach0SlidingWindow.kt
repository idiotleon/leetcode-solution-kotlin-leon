package com.idiotleon.leetcode.lvl4.lc0076

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Time Complexity:     O(max(`lenS`, `lenT`) ~ O(`lenT`)
 * Space Complexity:    O(128) ~ O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun minWindow(s: String, t: String): String {
        val lenS = s.length
        val lenT = t.length

        val charToFreq = IntArray(128) { 0 }
        for (ch in t) {
            ++charToFreq[ch.code]
        }

        var shortest = ""
        var count = lenT
        var hi = 0
        var lo = 0

        while (hi < lenS) {
            if (charToFreq[s[hi].code]-- > 0) --count

            while (count == 0) {
                if (shortest.isEmpty() || (hi - lo + 1) < shortest.length) {
                    shortest = s.substring(lo, hi + 1)
                }

                if (++charToFreq[s[lo].code] > 0) {
                    ++count
                }

                ++lo
            }

            ++hi
        }

        return shortest
    }
}