package com.idiotleon.leetcode.lvl2.lc0692

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * Time Complexity:     O(`nWords` * lg(`k`))
 * Space Complexity:    O(`k`)
 */
@Suppress(UNUSED)
class Solution0MinHeap {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val nWords = words.size
        val wordToFreq = HashMap<String, Int>(nWords).also {
            for (word in words) {
                it[word] = 1 + (it[word] ?: 0)
            }
        }

        val minHeap = PriorityQueue<String>(k) { a, b ->
            val freqA = wordToFreq[a] ?: 0
            val freqB = wordToFreq[b] ?: 0
            if (freqA == freqB) {
                b.compareTo(a)
            } else {
                freqA.compareTo(freqB)
            }
        }
        for ((word, _) in wordToFreq) {
            minHeap.offer(word)

            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        var idx = k - 1
        val ans = MutableList<String>(k) { "" }
        while (minHeap.isNotEmpty()) {
            val top = minHeap.poll()
            ans[idx] = top
            --idx
        }

        return ans
    }
}