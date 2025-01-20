package com.idiotleon.leetcode.lvl2.lc2273

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 *
 * Time Complexity:     O(`nWords`)
 * Space Complexity:    O(1) / O('nWords')
 */
@Suppress(UNUSED)
class Solution0HighLowPointers {
    fun removeAnagrams(words: Array<String>): List<String> {
        val nWords = words.size

        val ans = mutableListOf<String>().also {
            it.add(words[0])
        }
        var lo = 0
        var hi = 1
        while (hi < nWords) {
            while (hi < nWords && isAnagram(words[lo], words[hi])) {
                ++hi
            }
            if (hi < nWords) {
                ans.add(words[hi])
            }
            lo = hi
            ++hi
        }

        return ans
    }

    private fun isAnagram(word1: String, word2: String): Boolean {
        val len1 = word1.length
        val len2 = word2.length
        if (len1 != len2) {
            return false
        }
        val freqs = IntArray(26) { 0 }.also {
            for (ch in word1) {
                ++it[ch - 'a']
            }
        }
        for (ch in word2) {
            if (--freqs[ch - 'a'] < 0) {
                return false
            }
        }

        return true
    }
}