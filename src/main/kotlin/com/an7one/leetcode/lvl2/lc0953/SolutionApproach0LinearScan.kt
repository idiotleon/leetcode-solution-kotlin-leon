/**
 * @author: Leon
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 *
 * Time Complexity:     O(`nWord` * averageLenWord)
 * Space Complexity:    O(26) ~ O(1)
 */
package com.an7one.leetcode.lvl2.lc0953

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val dict = IntArray(26) { 0 }
        for ((idx, ch) in order.withIndex()) {
            dict[ch - 'a'] = idx
        }

        val nWords = words.size
        for (idx in 1 until nWords) {
            if (isBigger(words[idx - 1], words[idx], dict))
                return false
        }

        return true
    }

    private fun isBigger(prevWord: String, curWord: String, dict: IntArray): Boolean {
        val lenPrev = prevWord.length
        val lenCur = curWord.length
        val len = minOf(lenPrev, lenCur)

        for (idx in 0 until len) {
            val chPrev = prevWord[idx]
            val chCur = curWord[idx]

            if (chPrev != chCur)
                return dict[prevWord[idx] - 'a'] > dict[curWord[idx] - 'a']
        }

        return lenPrev > lenCur
    }
}