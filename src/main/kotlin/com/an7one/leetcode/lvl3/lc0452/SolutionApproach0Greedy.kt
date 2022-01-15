/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * Time Complexity:     O(`nPoints` * lg(`nPoints`))
 * Space Complexity:    O(1)
 *
 * Steps:
 *  1. to sort by end point
 *  2. to merge if cur[0] (start of cur) < last, otherwise, a new arrow is required (then to reset "last")
 *
 * References:
 *  http://zxi.mytechroad.com/blog/geometry/leetcode-452-minimum-number-of-arrows-to-burst-balloons/
 */
package com.an7one.leetcode.lvl3.lc0452

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        // sanity check
        if (points.isEmpty()) return 0

        // not used
        // val nPoints = points.size

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