/**
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * Time Complexity:     O(min(N, 3000))
 * Space Complexity:    O(min(N, 3000))
 *
 * References:
 *  https://leetcode.com/problems/number-of-recent-calls/discuss/189239/JavaPython-3-Five-solutions%3A-TreeMap-TreeSet-ArrayList-Queue-Circular-List.
 */
package com.zea7ot.leetcode.ood.lvl2.lc0933

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Queue {
    private companion object {
        private const val DURATION = 3000
    }

    private val queue = LinkedList<Int>()

    fun ping(t: Int): Int {
        queue.offer(t)
        while (queue.peek() < t - DURATION) {
            queue.poll()
        }

        return queue.size
    }
}