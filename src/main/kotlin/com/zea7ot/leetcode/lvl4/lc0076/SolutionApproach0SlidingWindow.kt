/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Time Complexity:     O(max(`LEN_S`, `LEN_T`) ~ O(`LEN_S`)
 * Space Complexity:    O(128) ~ O(1)
 */
package com.zea7ot.leetcode.lvl4.lc0076

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun minWindow(s: String, t: String): String {

        val lenS = s.length
        val lenT = t.length

        val freqs = IntArray(128) { 0 }
        for (ch in t) {
            ++freqs[ch.toInt()]
        }

        var shortest = ""
        var count = lenT
        var hi = 0
        var lo = 0

        while (hi < lenS) {
            if (freqs[s[hi].toInt()]-- > 0) --count

            while (count == 0) {
                if (shortest.isEmpty() || (hi - lo + 1) < shortest.length) {
                    shortest = s.substring(lo, hi + 1)
                }

                if (++freqs[s[lo].toInt()] > 0) {
                    ++count
                }

                ++lo
            }

            ++hi
        }

        return shortest
    }
}