package com.idiotleon.leetcode.lvl2.lc1100

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`) / O(1) + O(26) ~ O(`lenS`) / O(1)
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    fun numKLenSubstrNoRepeats(s: String, k: Int): Int {
        val lenS = s.length
        val freqs = IntArray(26) { 0 }
        var hi = 0
        var count = 0
        var len = 0
        while (hi < lenS) {
            val idxChHi = s[hi] - 'a'
            if (freqs[idxChHi] == 0) {
                ++len
                if (len == k) {
                    ++count
                }
            }
            ++freqs[idxChHi]

            if (hi + 1 >= k) {
                val lo = hi - k + 1
                val idxChLo = s[lo] - 'a'
                --freqs[idxChLo]
                if (freqs[idxChLo] == 0) {
                    --len
                }
            }

            ++hi
        }

        return count
    }
}