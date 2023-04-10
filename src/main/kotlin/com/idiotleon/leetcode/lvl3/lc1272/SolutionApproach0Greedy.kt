/**
 * @author: Leon
 * https://leetcode.com/problems/remove-interval/
 *
 * Time Complexity:     O(`nIntervals`)
 * Space Complexity:    O(1) / O(`nIntervals`)
 */
package com.idiotleon.leetcode.lvl3.lc1272

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun removeInterval(
        intervals: Array<IntArray>,
        toBeRemoved: IntArray
    ): List<List<Int>> {
        // not used
        // val nIntervals =intervals.size

        val ans = mutableListOf<List<Int>>()
        // sanity check
        if (toBeRemoved.isEmpty()) {
            for (interval in intervals) {
                ans.add(interval.toList())
            }

            return ans
        }


        val (start, end) = toBeRemoved
        for ((lo, hi) in intervals) {
            if (start in lo + 1 until hi) {
                ans.add(listOf(lo, start))
            }

            if (end in lo + 1 until hi) {
                ans.add(listOf(end, hi))
            }

            if (lo >= end || hi <= start) {
                ans.add(listOf(lo, hi))
            }
        }

        return ans
    }
}