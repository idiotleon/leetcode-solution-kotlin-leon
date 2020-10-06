/**
 * https://leetcode.com/problems/remove-covered-intervals/
 *
 * Time Complexity:     O(size * lg(size)) + O(size) ~ O(size * lg(size))
 *  size: total elements in the array
 * Space Complexity:    O(size)
 *  size: total elements in the array
 *
 * References:
 *  https://leetcode.com/problems/remove-covered-intervals/discuss/451284/JavaPython-3-Simple-codes-w-explanation-and-analysis.
 *  https://leetcode.com/problems/remove-covered-intervals/discuss/451277/JavaC%2B%2BPython-Sort-Solution-Test-Cases-are-Trash
 */
package com.zea7ot.leetcode.lvl3.lc1288

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        // sanity check
        if (intervals.isEmpty()) return 0

        // creating a new array, instead of sorting in place, seems to be hard to avoid
        // which bumps the space complexity from O(1) to O(size)
        val sorted = intervals.sortedWith(compareBy({ it[0] }, { -it[1] }))

        var curEnd = Int.MIN_VALUE
        var count = 0

        for (interval in sorted) {
            val end = interval[1]

            if (curEnd < end) {
                curEnd = end
                ++count
            }
        }

        return count
    }
}