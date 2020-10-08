/**
 * https://leetcode.com/problems/longest-happy-string/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/longest-happy-string/discuss/565831/java-detailed-explanation-greedy-priorityqueue-easy-understand-clear/724567
 */
package com.zea7ot.leetcode.lvl3.lc1405

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val builder = StringBuilder()
        val maxHeap = PriorityQueue<Letter>(compareBy { -it.freq })
        if (a > 0) maxHeap.add(Letter('a', a))
        if (b > 0) maxHeap.add(Letter('b', b))
        if (c > 0) maxHeap.add(Letter('c', c))

        while (maxHeap.isNotEmpty()) {
            val len = builder.length
            val most = maxHeap.poll()
            val ch = most.letter

            if (len < 2 || (builder[len - 2] != ch) || builder[len - 1] != ch) {
                builder.append(ch)
                --most.freq
            } else {
                if (maxHeap.isEmpty()) continue
                val secondMost = maxHeap.poll()
                builder.append(secondMost.letter)
                --secondMost.freq

                if (secondMost.freq > 0) {
                    maxHeap.add(secondMost)
                }
            }

            if (most.freq > 0) maxHeap.add(most)
        }

        return builder.toString()
    }

    private data class Letter(val letter: Char, var freq: Int)
}