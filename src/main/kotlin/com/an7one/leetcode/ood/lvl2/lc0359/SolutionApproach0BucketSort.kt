/**
 * https://leetcode.com/problems/logger-rate-limiter/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/logger-rate-limiter/discuss/83256/Java-Circular-Buffer-Solution-similar-to-Hit-Counter
 */
package com.an7one.leetcode.ood.lvl2.lc0359

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BucketSort {
    private companion object {
        private const val DURATION = 10
    }

    /** Initialize your data structure here. */
    private val timeBuckets = IntArray(DURATION) { 0 }
    private val mesBuckets = Array(DURATION) { hashSetOf<String>() }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        val idx = timestamp % DURATION
        if (timestamp != timeBuckets[idx]) {
            timeBuckets[idx] = timestamp
            mesBuckets[idx].clear()
        }

        for (i in timeBuckets.indices) {
            if (timestamp - timeBuckets[i] < DURATION) {
                if (mesBuckets[i].contains(message)) return false
            }
        }

        mesBuckets[idx].add(message)
        return true
    }
}