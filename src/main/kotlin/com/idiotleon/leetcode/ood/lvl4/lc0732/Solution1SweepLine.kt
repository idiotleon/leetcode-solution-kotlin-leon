package com.idiotleon.leetcode.ood.lvl4.lc0732

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/my-calendar-iii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/my-calendar-iii/discuss/702154/Four-AC-Solution%3A-TreeMap-BST-Segment-Tree-with-Diagrams-Beats-100-time-and-space-8ms-39.4MB
 */
@Suppress(UNUSED)
class Solution1SweepLine {
    private val timeline = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Int {
        timeline[start] = (timeline[start] ?: 0) + 1
        timeline[end] = (timeline[end] ?: 0) - 1

        var active = 0
        var most = 0
        for ((_, ongoing) in timeline) {
            active += ongoing
            most = maxOf(most, active)
        }

        return most
    }
}