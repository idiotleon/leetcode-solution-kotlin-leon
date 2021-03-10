/**
 * https://leetcode.com/problems/remove-covered-intervals/
 *
 * Time Complexity:     O(size * lg(size)) + O(size) ~ O(size * lg(size))
 *  size: total elements in the array
 *
 * Space Complexity:    O(1)
 *  size: total elements in the array
 *
 * References:
 *  https://leetcode.com/problems/remove-covered-intervals/discuss/451284/JavaPython-3-Simple-codes-w-explanation-and-analysis.
 *  https://leetcode.com/problems/remove-covered-intervals/discuss/451277/JavaC%2B%2BPython-Sort-Solution-Test-Cases-are-Trash
 */
package com.an7one.leetcode.lvl3.lc1288

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        // sanity check
        if (intervals.isEmpty()) return 0

        intervals.sortWith(compareBy({ it[0] }, { -it[1] }))

        var curEnd = Int.MIN_VALUE
        var count = 0

        for (interval in intervals) {
            val end = interval[1]

            if (curEnd < end) {
                curEnd = end
                ++count
            }
        }

        return count
    }
}