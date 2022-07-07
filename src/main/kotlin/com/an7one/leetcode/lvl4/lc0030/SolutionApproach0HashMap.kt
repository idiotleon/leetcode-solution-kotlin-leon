package com.an7one.leetcode.lvl4.lc0030

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * Time Complexity:     O(`lenS` * `nWords`) + O(`nWords`) ~ O(`lenS` * `nWords`)
 * Space Complexity:    O(`nWords` * `lenW`)
 *
 * Reference:
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/13664/Simple-Java-Solution-with-Two-Pointers-and-Map
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun findSubstring(str: String, words: Array<String>): List<Int> {

        val ans = mutableListOf<Int>()

        val lenS = str.length
        val nWords = words.size
        val lenW = words[0].length

        val wordToFreq = HashMap<String, Int>()
        for (word in words) {
            wordToFreq[word] = 1 + (wordToFreq[word] ?: 0)
        }

        for (lo in 0..lenS - nWords * lenW) {
            val copy = wordToFreq.toMutableMap()
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