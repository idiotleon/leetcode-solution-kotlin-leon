package com.idiotleon.leetcode.lvl4.lc0269

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/alien-dictionary/
 *
 * Time Complexity:     O(`nWords` * avgLenWord)
 * Space Complexity:    O(`nWords` * avgLenWord)
 */
@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    private companion object {
        private const val TOTAL_ALPHABET = 26
    }

    fun alienOrder(words: Array<String>): String {
        // sanity check
        if (words.isEmpty()) {
            return ""
        }

        val nWords = words.size

        val freqs = IntArray(TOTAL_ALPHABET) { -1 }
        for (word in words) {
            for (ch in word) {
                freqs[ch - 'a'] = 0
            }
        }

        val graph = Array(TOTAL_ALPHABET) { hashSetOf<Int>() }

        for (idxWord in 1 until nWords) {
            val wordPrev = words[idxWord - 1]
            val wordCur = words[idxWord]

            val lenPrev = wordPrev.length
            val lenCur = wordCur.length
            val len = maxOf(lenPrev, lenCur)

            for (idxCh in 0 until len) {
                if (idxCh == lenPrev) {
                    break
                } else if (idxCh == lenCur) {
                    return ""
                } else {
                    val chPrev = wordPrev[idxCh]
                    val chCur = wordCur[idxCh]
                    if (chPrev == chCur) {
                        continue
                    }

                    val idxChPrev = chPrev - 'a'
                    val idxChCur = chCur - 'a'
                    if (graph[idxChPrev].add(idxChCur)) {
                        ++freqs[idxChCur]
                    }

                    break
                }
            }
        }

        val queue = ArrayDeque<Int>()
        for (i in 0 until TOTAL_ALPHABET) {
            if (freqs[i] == 0) {
                queue.addLast(i)
            }
        }

        val builder = StringBuilder()
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val cur = queue.removeFirst()
                val ch = (cur + 'a'.code).toChar()
                builder.append(ch)

                for (next in graph[cur]) {
                    if (--freqs[next] == 0) {
                        queue.addLast(next)
                    }
                }
            }
        }

        for (freq in freqs) {
            if (freq > 0) {
                return ""
            }
        }

        return builder.toString()
    }
}