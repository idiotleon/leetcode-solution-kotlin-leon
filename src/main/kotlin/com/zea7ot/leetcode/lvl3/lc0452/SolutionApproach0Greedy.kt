/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * Time Complexity:     O(`totalPoints` * lg(`totalPoints`))
 * Space Complexity:    O(1)
 *
 * Steps:
 *  1. to sort by end point
 *  2. to merge if cur[0] (start of cur) < last, otherwise, a new arrow is required (then to reset "last")
 *
 * References:
 *  http://zxi.mytechroad.com/blog/geometry/leetcode-452-minimum-number-of-arrows-to-burst-balloons/
 */
package com.zea7ot.leetcode.lvl3.lc0452

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        // sanity check
        if (points.isEmpty()) return 0

        // not used
        // val totalPoints = points.size

        points.sortBy { it[1] }

        var prevEnd = points[0][1]
        var arrows = 1

        for (point in points) {
            if (point[0] > prevEnd) {
                prevEnd = point[1]
                ++arrows
            }
        }

        return arrows
    }
}