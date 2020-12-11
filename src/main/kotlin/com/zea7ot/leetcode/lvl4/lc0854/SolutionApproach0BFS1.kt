/**
 * https://leetcode.com/problems/k-similar-strings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-similar-strings/discuss/140099/JAVA-BFS-32-ms-cleanconciseexplanationwhatever/176099
 *  https://leetcode.com/problems/k-similar-strings/discuss/140099/JAVA-BFS-32-ms-cleanconciseexplanationwhatever
 */
package com.zea7ot.leetcode.lvl4.lc0854

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS1 {
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

                val len = cur.length
                var lo = 0
                while (lo < len && cur[lo] == B[lo]) {
                    ++lo
                }

                for (hi in lo + 1 until len) {
                    if (cur[hi] == B[lo] && cur[hi] != B[hi]) { // by definition: similar
                        val next = swap(lo, hi, cur)
                        if (!seen.add(next)) continue
                        queue.offer(next)
                    }
                }
            }

            ++k
        }

        return -1
    }

    private fun swap(lo: Int, hi: Int, str: String): String {
        val chs = str.toCharArray()
        val temp = chs[lo]
        chs[lo] = chs[hi]
        chs[hi] = temp

        return String(chs)
    }
}