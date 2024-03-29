/**
 * https://leetcode.com/problems/logger-rate-limiter/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/logger-rate-limiter/discuss/365306/Simple-Two-HashMap-Solution-with-O(1)-time-and-little-memory
 *  https://leetcode.com/problems/logger-rate-limiter/discuss/391558/Review-of-four-different-solutions%3A-HashMap-Two-Sets-Queue-with-Set-Radix-buckets-(Java-centric)
 */
package com.idiotleon.leetcode.ood.lvl2.lc0359

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private companion object {
        private const val DURATION = 10
    }

    private var cacheOld = HashMap<String, Int>()
    private var cacheNew = HashMap<String, Int>()
    private var latest = 0

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (timestamp >= latest + DURATION * 2) {
            cacheOld.clear()
            cacheNew.clear()
            latest = timestamp
        } else if (timestamp >= latest + DURATION) {
            cacheOld = cacheNew
            cacheNew = HashMap()
            latest = timestamp
        }

        cacheNew[message]?.let { return false }

        cacheOld[message]?.let { last ->
            if (last + DURATION > timestamp)
                return false
        }

        cacheNew[message] = timestamp
        return true
    }
}