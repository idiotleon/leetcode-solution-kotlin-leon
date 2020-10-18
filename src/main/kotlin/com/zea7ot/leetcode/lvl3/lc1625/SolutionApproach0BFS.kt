/**
 * https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl3.lc1625

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        var smallest = s

        val queue = LinkedList<String>()
        queue.offer(s)

        val seen = HashSet<String>()
        seen.add(s)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (cur < smallest) {
                    smallest = cur
                }

                val added = add(cur, a)
                if (seen.add(added)) {
                    queue.offer(added)
                }

                val rotated = rotate(cur, b)
                if (seen.add(rotated)) {
                    queue.offer(rotated)
                }
            }
        }

        return smallest
    }

    private fun add(s: String, a: Int): String {
        val lenS = s.length
        val chs = s.toCharArray()

        for (idx in 1 until lenS step 2) {
            val digit = (chs[idx] - '0' + a) % 10
            chs[idx] = ('0' + digit).toChar()
        }

        return String(chs)
    }

    private fun rotate(s: String, b: Int): String {
        val lenS = s.length
        val chs = s.toCharArray()

        reverse(0, lenS, chs)
        reverse(0, b, chs)
        reverse(b, lenS, chs)

        return String(chs)
    }

    private fun reverse(low: Int, high: Int, chs: CharArray) {
        var lo = low
        var hi = high - 1

        while (lo < hi) {
            swap(lo++, hi--, chs)
        }
    }

    private fun swap(lo: Int, hi: Int, chs: CharArray) {
        val temp = chs[lo]
        chs[lo] = chs[hi]
        chs[hi] = temp
    }
}