/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 *
 * Time Complexity:     O(`totalWords` * `lenP`)
 * Space Complexity:    O(`totalWords` * `lenP`)
 *
 * References:
 *  https://leetcode.com/problems/find-and-replace-pattern/discuss/161376/Java-two-maps-solution
 */
package com.zea7ot.leetcode.lvl3.lc0890

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        // not used
        // val totalWords = words.size
        // val lenP = pattern.length

        val ans = ArrayList<String>()

        for (word in words) {
            if (matches(word, pattern)) {
                ans.add(word)
            }
        }

        return ans
    }

    private fun matches(word: String, pattern: String): Boolean {
        val wordToPattern = HashMap<Char, Char>()
        val patternToWord = HashMap<Char, Char>()

        for (idx in word.indices) {
            val curChW = word[idx]
            val curChP = pattern[idx]

            val prevChP = wordToPattern.getOrPut(curChW) { curChP }
            val prevChW = patternToWord.getOrPut(curChP) { curChW }

            if (curChW != prevChW || curChP != prevChP) return false
        }

        return true
    }
}