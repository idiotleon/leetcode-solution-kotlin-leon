/**
 * @author: Leon
 * https://leetcode.com/problems/unique-morse-code-words/
 *
 * Time Complexity:     O(`nWords` * lenW)
 * Space Complexity:    O(`nWords` * lenW)
 */
package com.zea7ot.leetcode.lvl1.lc0804

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashSet {
    private companion object {
        private val MORSE = arrayOf(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")
    }

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        // not used
        // val nWords = words.size

        val seen = HashSet<String>()
        for (word in words) {
            val builder = StringBuilder()
            for (ch in word) {
                builder.append(MORSE[ch - 'a'])
            }

            seen.add(builder.toString())
        }

        return seen.size
    }
}