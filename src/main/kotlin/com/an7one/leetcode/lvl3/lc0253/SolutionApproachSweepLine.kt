package com.an7one.leetcode.lvl3.lc0253

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 *
 * overlapped edge points are NOT counted,
 *  eg: [[1, 2], [2, 3]] is NOT considered as overlapped
 *
 * Reference:
 * https://leetcode.com/problems/my-calendar-iii/discuss/109556/JavaC++-Clean-Code/111457
 */
@Suppress(UNUSED)
class SolutionApproachSweepLine {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        // sanity check
        if (intervals.isEmpty()) return 0

        // a treemap: time(stamp) sorted to freq(uency)
        val timeline = TreeMap<Int, Int>()
        for (interval in intervals) {
            val start = interval[0]
            val end = interval[1]

            timeline[start] = (timeline[start] ?: 0) + 1
            timeline[end] = (timeline[end] ?: 0) - 1
        }

        var count = 0
        var required = 0
        for ((_, freq) in timeline) {
            count += freq
            required = maxOf(required, count)
        }

        return required
    }
}