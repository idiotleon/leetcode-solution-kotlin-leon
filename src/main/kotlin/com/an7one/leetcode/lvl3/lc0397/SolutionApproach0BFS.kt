package com.an7one.leetcode.lvl3.lc0397

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/integer-replacement/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun integerReplacement(n: Int): Int {
        if (n == 1) return 0

        val num = n.toLong()
        val queue = ArrayDeque<Long>()
        val seen = HashSet<Long>()
        if (n % 2 == 0) {
            queue.addLast(num / 2)
            seen.add(num / 2)
        } else {
            queue.addLast(num + 1)
            seen.add(num + 1)

            queue.addLast(num - 1)
            seen.add(num - 1)
        }

        var steps = 1

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()

                if (cur == 1L) return steps

                if (cur % 2 == 0L) {
                    val next = cur / 2
                    if (seen.add(next)) queue.addLast(next)
                } else {
                    val next1 = cur + 1
                    if (seen.add(next1)) queue.addLast(next1)

                    val next2 = cur - 1
                    if (seen.add(next2)) queue.addLast(next2)
                }
            }

            ++steps
        }

        return steps
    }
}