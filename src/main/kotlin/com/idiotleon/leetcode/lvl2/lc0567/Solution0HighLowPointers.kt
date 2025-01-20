package com.idiotleon.leetcode.lvl2.lc0567

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/permutation-in-string/
 *
 * Time Complexity:     O(`lenS1` + `lenS2`) ~ O(maxOf(`lenS1`, `lenS2`))
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0HighLowPointers {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val lenS1 = s1.length
        val lenS2 = s2.length

        val freqs = IntArray(26) { 0 }.also {
            for (ch in s1) {
                ++it[ch - 'a']
            }
        }

        var count = lenS1
        for ((hi, ch) in s2.withIndex()) {
            val idxChHi = ch - 'a'
            if (freqs[idxChHi] > 0) {
                --count
                if (count == 0) {
                    return true
                }
            }
            --freqs[idxChHi]

            if (hi >= lenS1 - 1) {
                val lo = hi - lenS1 + 1
                val idxChLo = s2[lo] - 'a'
                ++freqs[idxChLo]
                if (freqs[idxChLo] > 0) {
                    ++count
                }
            }
        }

        return false
    }
}