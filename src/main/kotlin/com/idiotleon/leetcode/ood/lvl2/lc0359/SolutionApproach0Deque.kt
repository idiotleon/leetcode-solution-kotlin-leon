/**
 * https://leetcode.com/problems/logger-rate-limiter/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/logger-rate-limiter/discuss/83273/Short-C++JavaPython-bit-different/638605
 *  https://leetcode.com/problems/logger-rate-limiter/discuss/391558/Review-of-four-different-solutions%3A-HashMap-Two-Sets-Queue-with-Set-Radix-buckets-(Java-centric)
 */
package com.idiotleon.leetcode.ood.lvl2.lc0359

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

@Suppress(UNUSED)
class SolutionApproach0Deque {
    private companion object {
        private const val DURATION = 10
    }

    /** Initialize your data structure here. */
    private val seen = HashSet<String>()
    private val deque = LinkedList<Log>()

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        while (deque.isNotEmpty() && deque.peekFirst().timestamp <= timestamp - DURATION) {
            val cur = deque.removeFirst()
            seen.remove(cur.message)
        }

        if (seen.contains(message)) return false

        seen.add(message)
        deque.addLast(Log(timestamp, message))
        return true
    }

    private data class Log(val timestamp: Int, val message: String)
}