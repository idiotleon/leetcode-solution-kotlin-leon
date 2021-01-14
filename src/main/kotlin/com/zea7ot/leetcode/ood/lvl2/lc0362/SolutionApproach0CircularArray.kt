/**
 * https://leetcode.com/problems/design-hit-counter/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/design-hit-counter/discuss/83490/Java-Circular-Array-Solution-with-a-really-detailed-explanation-post.
 *  https://leetcode.com/problems/design-hit-counter/discuss/83483/Super-easy-design-O(1)-hit()-O(s)-getHits()-no-fancy-data-structure-is-needed!
 */
package com.zea7ot.leetcode.ood.lvl2.lc0362

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CircularArray {
    private companion object {
        private const val TIME_FRAME = 300
    }

    /** Initialize your data structure here. */
    private val times = IntArray(TIME_FRAME) { 0 }
    private val hits = IntArray(TIME_FRAME) { 0 }


    /** Record a hit.
    @param timestamp - The current timestamp (in seconds granularity). */
    fun hit(timestamp: Int) {
        val idx = timestamp % TIME_FRAME

        if (times[idx] != timestamp) {
            times[idx] = timestamp
            hits[idx] = 1
        } else {
            ++hits[idx]
        }
    }

    /** Return the number of hits in the past 5 minutes.
    @param timestamp - The current timestamp (in seconds granularity). */
    fun getHits(timestamp: Int): Int {
        var totalHits = 0

        for (idx in 0 until TIME_FRAME) {
            if (timestamp - times[idx] < TIME_FRAME) {
                totalHits += hits[idx]
            }
        }

        return totalHits
    }
}