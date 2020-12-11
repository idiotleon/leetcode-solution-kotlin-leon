/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * could you please output the schedules of all meeting rooms, in below orders:
 *  1. to sorted by meeting room IDs
 *  2. with 1 satisfied, to sort by starting time
 *
 * e.g.:
 *  given input:
 *      intervals: [[0, 30], [5, 10], [15, 20]]
 *
 * expected output, for reference only:
 *  [0, 0, 30], means that meeting room, ID 0, is occupied from 0 to 30
 *  [1, 5, 10], means that meeting room, ID 1, is occupied from 5 to 10
 *  [1, 15, 20], means that meeting room, ID 1, is occupied from 15 to 20
 * or
 *  {{[0, 30]}, {[5, 10], [15, 20]}}
 *
 * this solution has NOT been verified yet
 */
package com.zea7ot.leetcode.lvl3.lc0253.followups.followup0

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0SweepLine {
    fun meetingRoomsSchedules(intervals: Array<IntArray>): List<List<IntArray>> {
        val schedules: MutableList<MutableList<IntArray>> = arrayListOf()
        // sanity check
        if (intervals.isEmpty()) return schedules

        intervals.sortBy { it[0] }
        val timeline = TreeMap<Int, Int>()
        for (interval in intervals) {
            val start = interval[0]
            val end = interval[1]

            timeline[start] = (timeline[start] ?: 0) + 1
            timeline[end] = (timeline[end] ?: 0) - 1
        }

        var id = 0
        var prevFreq = 0
        var curFreq = 0
        for ((timestamp, freq) in timeline) {
            curFreq += freq

            if (prevFreq < curFreq) {
                val size = schedules.size
                if (size < id + 1) {
                    schedules.add(arrayListOf())
                }
                schedules[id].add(intArrayOf(timestamp, -1))
                ++id
            } else if (prevFreq > curFreq) {
                --id
                schedules[id].last()[1] = timestamp
            }

            prevFreq = curFreq
        }

        return schedules
    }
}