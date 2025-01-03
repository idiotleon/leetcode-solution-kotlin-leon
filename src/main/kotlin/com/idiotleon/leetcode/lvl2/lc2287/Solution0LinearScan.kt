package com.idiotleon.leetcode.lvl2.lc2287

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/rearrange-characters-to-make-target-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    private companion object {
        private const val RANGE = 100 + 1
    }

    fun rearrangeCharacters(s: String, target: String): Int {
        val lenS = s.length

        val freqsS = IntArray(26).also {
            for (ch in s) {
                ++it[ch - 'a']
            }
        }

        val freqsT = IntArray(26).also {
            for (ch in target) {
                ++it[ch - 'a']
            }
        }

        var min = RANGE
        for ((idx, freq) in freqsT.withIndex()) {
            if (freq > 0) {
                val times = freqsS[idx] / freq
                min = minOf(min, times)
            }
        }

        return min
    }
}