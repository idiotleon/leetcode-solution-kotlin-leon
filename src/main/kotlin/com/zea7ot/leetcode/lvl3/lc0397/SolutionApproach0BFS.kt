/**
 * @author: Leon
 * https://leetcode.com/problems/integer-replacement/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl3.lc0397

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun integerReplacement(n: Int): Int {
        if (n == 1) return 0

        val num = n.toLong()
        val queue = LinkedList<Long>()
        val seen = HashSet<Long>()
        if (n % 2 == 0) {
            queue.offer(num / 2)
            seen.add(num / 2)
        } else {
            queue.offer(num + 1)
            seen.add(num + 1)

            queue.offer(num - 1)
            seen.add(num - 1)
        }

        var steps = 1

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (cur == 1L) return steps

                if (cur % 2 == 0L) {
                    val next = cur / 2
                    if (seen.add(next)) {
                        queue.offer(next)
                    }
                } else {
                    val next1 = cur + 1
                    if (seen.add(next1)) {
                        queue.offer(next1)
                    }

                    val next2 = cur - 1
                    if (seen.add(next2)) {
                        queue.offer(next2)
                    }
                }
            }

            ++steps
        }

        return steps
    }
}