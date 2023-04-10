/**
 * @author: Leon
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 *
 * Time Complexity:     O(`nWords` * `lenS`)
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl3.lc0524

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun findLongestWord(s: String, d: List<String>): String {
        // not used
        // val nWords = d.size

        var longest = ""

        val lenS = s.length

        for (word in d) {
            var idxS = 0
            var idxW = 0

            val lenW = word.length

            while (idxS < lenS) {
                if (idxW < lenW && s[idxS] == word[idxW]) {
                    ++idxW
                }

                ++idxS
            }

            if (idxW == lenW) {
                if (word.length > longest.length) {
                    longest = word
                } else if (word.length == longest.length) {
                    if (word < longest) {
                        longest = word
                    }
                }
            }
        }

        return longest
    }
}