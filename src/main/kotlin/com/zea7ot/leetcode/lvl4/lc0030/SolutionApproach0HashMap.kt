/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * Time Complexity:     O(`lenS` * `nWords`) + O(`nWords`) ~ O(`lenS` * `nWords`)
 * Space Complexity:    O(`nWords` * `lenW`)
 *
 * References:
 *  https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13664/Simple-Java-Solution-with-Two-Pointers-and-Map
 */
package com.zea7ot.leetcode.lvl4.lc0030

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun findSubstring(str: String, words: Array<String>): List<Int> {

        val ans = mutableListOf<Int>()

        val lenS = str.length
        val nWords = words.size
        val lenW = words[0].length

        val freqs = HashMap<String, Int>()
        for (word in words) {
            freqs[word] = 1 + (freqs[word] ?: 0)
        }

        for (lo in 0..lenS - nWords * lenW) {
            val copy = freqs.toMutableMap()
            for (hi in 0 until nWords) {
                val nextWord = str.substring(lo + hi * lenW, lo + hi * lenW + lenW)
                if (copy.containsKey(nextWord)) {
                    val count = copy[nextWord]!!
                    if (count == 1) copy.remove(nextWord)
                    else copy[nextWord] = count - 1

                    if (copy.isEmpty()) {
                        ans.add(lo)
                        break
                    }
                } else break
            }
        }

        return ans
    }
}