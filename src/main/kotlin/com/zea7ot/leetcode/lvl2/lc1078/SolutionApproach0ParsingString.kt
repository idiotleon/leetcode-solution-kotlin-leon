/**
 * https://leetcode.com/problems/occurrences-after-bigram/
 *
 * Time Complexity:     O(`lenT`)
 * Space Complexity:    O(`lenT`)
 *
 * References:
 *  https://leetcode.com/problems/occurrences-after-bigram/discuss/308224/JavaPython-3-Split-String.
 */
package com.zea7ot.leetcode.lvl2.lc1078

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    private companion object {
        private const val SPACE = " "
    }

    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        // not used
        // val lenT = text.length

        val words = text.split(SPACE)
        val nWords = words.size

        val ans = ArrayList<String>()

        for (idx in 2 until nWords) {
            if (first == words[idx - 2] && second == words[idx - 1]) {
                ans.add(words[idx])
            }
        }

        return ans.toTypedArray()
    }
}