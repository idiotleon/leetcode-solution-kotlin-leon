/**
 * https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1) + O(26) ~ O(`lenS`) / O(1)
 */
package com.zea7ot.leetcode.lvl2.lc1100

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun numKLenSubstrNoRepeats(str: String, K: Int): Int {
        val lenS = str.length
        var count = 0

        var lo = 0
        var hi = 0
        var distinct = 0

        val freqs = IntArray(26) { 0 }

        while (hi < lenS) {
            if (freqs[str[hi] - 'a']++ == 0) ++distinct

            if (distinct == K) ++count

            if (hi - lo + 1 == K) {
                if (--freqs[str[lo] - 'a'] == 0) --distinct
                ++lo
            }

            ++hi
        }

        return count
    }
}