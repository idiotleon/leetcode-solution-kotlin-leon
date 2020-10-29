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
package com.zea7ot.leetcode.ood.lc0359

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap() {
    /** Initialize your data structure here. */
    private var cacheOld = HashMap<String, Int>()
    private var cacheNew = HashMap<String, Int>()
    private var latest = 0

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if (timestamp >= latest + 20) {
            cacheOld.clear()
            cacheNew.clear()
            latest = timestamp
        } else if (timestamp >= latest + 10) {
            cacheOld = cacheNew
            cacheNew = HashMap()
            latest = timestamp
        }

        cacheNew[message]?.let { return false }

        cacheOld[message]?.let { last ->
            if (last + 10 > timestamp) return false
        }

        cacheNew[message] = timestamp
        return true
    }
}