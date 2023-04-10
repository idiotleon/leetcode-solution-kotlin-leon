package com.idiotleon.leetcode.lvl4.lc0127

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/word-ladder/
 *
 * Time Complexity:     O(`nWords`) + O(`nWords` * (26 ^ (L / 2))) ~ O(`nWords` * (26 ^ (L / 2)))
 * Space Complexity:    O(`nWords` * L) / O(`nWords`)
 *
 * Bidirectional BFS
 *
 * Reference:
 * https://www.youtube.com/watch?v=vWPCm69MSfs
 * http://zxi.mytechroad.com/blog/searching/127-word-ladder/
 * https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        // not used
        // val nWords = wordList.size

        val wordSet = HashSet(wordList)

        // sanity check
        if (!wordSet.contains(endWord)) return 0

        var beginSet = HashSet<String>().also {
            it.add(beginWord)
        }
        var endSet = HashSet<String>().also {
            it.add(endWord)
        }

        var steps = 1

        while (beginSet.isNotEmpty() && endSet.isNotEmpty()) {
            // to always start with the shorter set
            if (beginSet.size > endSet.size) {
                // to swap
                beginSet = endSet.also { endSet = beginSet }
            }

            val nextSet = HashSet<String>()
            for (word in beginSet) {
                val len = word.length
                val chs = word.toCharArray()

                for (idx in 0 until len) {
                    val hold = chs[idx]

                    for (ch in 'a'..'z') {
                        chs[idx] = ch
                        val nextWord = String(chs)
                        if (endSet.contains(nextWord)) return 1 + steps

                        if (!wordSet.contains(nextWord)) continue
                        nextSet.add(nextWord)
                        wordSet.remove(nextWord)
                    }

                    chs[idx] = hold
                }
            }

            beginSet = nextSet
            ++steps
        }

        return 0
    }
}