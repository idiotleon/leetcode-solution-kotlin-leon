/**
 * https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/discuss/794072/Java-Easy-Understanding-BFS
 */
package com.zea7ot.leetcode.lvl4.lc1553

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun minDays(n: Int): Int {
        if (n <= 0) return 0

        val queue = LinkedList<Int>().also {
            it.offer(n)
        }

        val seen = HashSet<Int>()

        var days = 1

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val oranges = queue.poll()

                if (oranges == 1) return days

                if (!seen.add(oranges)) continue

                if (oranges % 3 == 0) {
                    queue.offer(oranges / 3)
                }

                if (oranges % 2 == 0) {
                    queue.offer(oranges / 2)
                }

                queue.offer(oranges - 1)
            }

            ++days
        }

        return -1
    }
}