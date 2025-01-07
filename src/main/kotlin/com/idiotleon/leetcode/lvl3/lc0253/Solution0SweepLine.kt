package com.idiotleon.leetcode.lvl3.lc0253

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Time Complexity:     O(`nIntervals` * lg(`nIntervals`))
 * Space Complexity:    O(`nIntervals`)
 */
@Suppress(UNUSED)
class Solution0SweepLine {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val nIntervals = intervals.size
        val timeline = TreeMap<Int, Int>().also {
            for ((start, end) in intervals) {
                it[start] = (it[start] ?: 0) + 1
                it[end] = (it[end] ?: 0) - 1
            }
        }

        var cur = 0
        var required = 1
        for ((_, freq) in timeline) {
            cur += freq
            required = maxOf(required, cur)
        }

        return required
    }
}