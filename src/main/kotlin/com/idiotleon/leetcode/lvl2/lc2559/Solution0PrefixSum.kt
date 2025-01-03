package com.idiotleon.leetcode.lvl2.lc2559

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-vowel-strings-in-ranges/
 *
 * Time Complexity:     O(`nWords` + `nQueries`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0PrefixSum {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val nWords = words.size
        val nQueries = queries.size
        val prefixSums = IntArray(nWords) { 0 }.also {
            var sum = 0
            for ((idx, word) in words.withIndex()) {
                if (isVowelString(word)) {
                    ++sum
                }
                it[idx] = sum
            }
        }

        val ans = IntArray(nQueries) { 0 }
        for ((idx, query) in queries.withIndex()) {
            val (lo, hi) = query
            ans[idx] = prefixSums[hi] - if (lo == 0) 0 else prefixSums[lo - 1]
        }

        return ans
    }

    private fun isVowelString(word: String): Boolean = isVowel(word[0]) && isVowel(word.last())

    private fun isVowel(ch: Char): Boolean {
        val allVowels = listOf('a', 'e', 'u', 'i', 'o')
        for (vowel in allVowels) {
            if (ch == vowel) {
                return true
            }
        }
        return false
    }
}