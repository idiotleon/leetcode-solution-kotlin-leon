package com.idiotleon.leetcode.lvl2.lc1160

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * Time Complexity:     O(`nWords` * averageLengthWord)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val nWords = words.size
        val lenChs = chars.length

        val freqs = IntArray(26).also {
            for (ch in chars) {
                ++it[ch - 'a']
            }
        }

        var ans = 0
        for (word in words) {
            if (isGood(word, freqs)) {
                ans += word.length
            }
        }

        return ans
    }

    private fun isGood(word: String, freqs: IntArray): Boolean {
        val freqWord = IntArray(26).also {
            for (ch in word) {
                ++it[ch - 'a']
            }
        }
        for ((idx, freq) in freqWord.withIndex()) {
            if (freq > freqs[idx]) {
                return false
            }
        }
        return true
    }
}