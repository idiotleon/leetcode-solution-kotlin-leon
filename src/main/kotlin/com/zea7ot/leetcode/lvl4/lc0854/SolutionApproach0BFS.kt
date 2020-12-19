/**
 * https://leetcode.com/problems/k-similar-strings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-similar-strings/discuss/151500/Logical-Thinking-with-Clear-Java-Code
 */
package com.zea7ot.leetcode.lvl4.lc0854

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun kSimilarity(A: String, B: String): Int {
        val queue = LinkedList<String>()
        queue.offer(A)
        val seen = HashSet<String>()
        seen.add(A)

        var k = 0
        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                if (cur == B) return k

                for (neighbour in getNeighbours(cur, B)) {
                    if (!seen.add(neighbour)) continue
                    queue.offer(neighbour)
                }
            }

            ++k
        }

        return -1
    }

    private fun getNeighbours(str: String, B: String): ArrayList<String> {
        val neighbours = arrayListOf<String>()

        val chs = str.toCharArray()
        val lenS = str.length

        var lo = 0
        while (lo < lenS && chs[lo] == B[lo]) {
            ++lo
        }

        for (hi in lo + 1 until lenS) {
            if (chs[hi] == B[lo]) {
                swap(lo, hi, chs)
                neighbours.add(String(chs))
                swap(lo, hi, chs)
            }
        }

        return neighbours
    }

    private fun swap(lo: Int, hi: Int, chs: CharArray) {
        val temp = chs[lo]
        chs[lo] = chs[hi]
        chs[hi] = temp
    }
}