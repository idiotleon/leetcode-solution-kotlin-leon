/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Time Complexity:     O(`totalWords`) + O(`totalWords` * (26 ^ (L / 2))) ~ O(`totalWords` * (26 ^ (L / 2)))
 * Space Complexity:    O(`totalWords` * L) / O(`totalWords`)
 *
 * Bidirectional BFS
 *
 * References:
 *  https://www.youtube.com/watch?v=vWPCm69MSfs
 *  http://zxi.mytechroad.com/blog/searching/127-word-ladder/
 *  https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
 */
package com.zea7ot.leetcode.lvl4.lc0127

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        // not used
        // val totalWords = wordList.size

        val wordSet = HashSet(wordList)

        // sanity check
        if (!wordSet.contains(endWord)) return 0

        var beginSet = HashSet<String>()
        beginSet.add(beginWord)
        var endSet = HashSet<String>()
        endSet.add(endWord)

        var steps = 1

        while (beginSet.isNotEmpty() && endSet.isNotEmpty()) {
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