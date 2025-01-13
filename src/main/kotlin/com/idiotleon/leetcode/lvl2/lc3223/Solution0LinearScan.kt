package com.idiotleon.leetcode.lvl2.lc3223

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun minimumLength(s: String): Int {
        val lenS = s.length
        val freqs = IntArray(26) { 0 }.also {
            for (ch in s) {
                ++it[ch - 'a']
            }
        }

        var len = 0
        for (freq in freqs) {
            len += getLength(freq)
        }

        return len
    }

    private fun getLength(freq: Int): Int {
        var freq = freq
        while (freq >= 3) {
            freq -= (freq / 3) * 2
        }
        return freq
    }
}