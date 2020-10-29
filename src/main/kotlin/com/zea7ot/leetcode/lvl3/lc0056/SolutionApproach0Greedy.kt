/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Time Complexity:     O(`totalIntervals` * lg(`totalIntervals`)) + O(`totalIntervals`) ~ O(`totalIntervals` * lg(`totalIntervals`))
 * Space Complexity:    O(`totalIntervals`)
 */
package com.zea7ot.leetcode.lvl3.lc0056

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        // not used
        // val totalIntervals = intervals.size

        intervals.sortBy { it[0] }

        val merged = ArrayList<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty() || merged.last()[1] < interval[0]) {
                merged.add(interval)
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }

        return merged.toTypedArray()
    }
}