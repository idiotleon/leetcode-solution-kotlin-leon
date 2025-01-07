package com.idiotleon.leetcode.lvl2.lc0252

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/meeting-rooms/
 *
 * Time Complexity:     O(`nIntervals` * lg(`nIntervals`))
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScanAfterSort {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        val nIntervals = intervals.size
        intervals.sortBy { it[0] }

        for (idx in 0 until nIntervals - 1) {
            if (intervals[idx][1] > intervals[idx + 1][0]) {
                return false
            }
        }

        return true
    }
}