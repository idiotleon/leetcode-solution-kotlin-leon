/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 *
 * Time Complexity:     O(N * lg(N)) + O(RANGE)
 * Space Complexity:    O(RANGE)
 */
package com.zea7ot.leetcode.lvl3.lc1353

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    private companion object {
        private const val RANGE = 1e5.toInt() + 1
    }

    fun maxEvents(events: Array<IntArray>): Int {
        events.sortBy { it[1] }

        var max = 0
        val seen = BooleanArray(RANGE) { false }

        for (event in events) {
            val (start, end) = event

            for (idx in start..end) {
                if (seen[idx]) continue
                seen[idx] = true
                ++max
                break
            }
        }

        return max
    }
}