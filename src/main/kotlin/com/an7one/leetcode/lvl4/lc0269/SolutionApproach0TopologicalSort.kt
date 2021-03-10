/**
 * @author: Leon
 * https://leetcode.com/problems/alien-dictionary/
 *
 * Time Complexity:     O(N * L)
 * Space Complexity:    O(N * L)
 */
package com.an7one.leetcode.lvl4.lc0269

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    private companion object {
        private const val TOTAL_ALPHABET = 26
    }

    fun alienOrder(words: Array<String>): String {
        // sanity check
        if (words.isEmpty()) return ""

        val sizeW = words.size

        val freqs = IntArray(TOTAL_ALPHABET) { -1 }
        for (word in words) {
            for (ch in word) {
                freqs[ch - 'a'] = 0
            }
        }

        val graph = Array(TOTAL_ALPHABET) { hashSetOf<Int>() }

        for (i in 1 until sizeW) {
            val wordPrev = words[i - 1]
            val wordCur = words[i]

            val lenPrev = wordPrev.length
            val lenCur = wordCur.length
            val len = maxOf(lenPrev, lenCur)

            for (j in 0 until len) {
                if (j == lenPrev) break
                else if (j == lenCur) return ""
                else {
                    val chPrev = wordPrev[j]
                    val chCur = wordCur[j]
                    if (chPrev == chCur) continue

                    val idxChPrev = chPrev - 'a'
                    val idxChCur = chCur - 'a'
                    if (graph[idxChPrev].add(idxChCur)) {
                        ++freqs[idxChCur]
                    }

                    break
                }
            }
        }

        val queue = LinkedList<Int>()
        for (i in 0 until TOTAL_ALPHABET) {
            if (freqs[i] == 0) {
                queue.offer(i)
            }
        }

        val builder = StringBuilder()
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val cur = queue.poll()
                val ch = (cur + 'a'.toInt()).toChar()
                builder.append(ch)

                for (next in graph[cur]) {
                    if (--freqs[next] == 0) {
                        queue.offer(next)
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