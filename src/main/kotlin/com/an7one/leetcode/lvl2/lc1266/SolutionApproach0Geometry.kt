/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 *
 * Time Complexity:     O(`nPts`)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/minimum-time-visiting-all-points/discuss/436250/JavaPython-3-6-liner-and-1-liner-w-brief-explanation-and-analysis.
 */
package com.an7one.leetcode.lvl2.lc1266

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0Geometry {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        val nPts = points.size

        var ans = 0

        for (idx in 1 until nPts) {
            val (curRow, curCol) = points[idx]
            val (prevRow, prevCol) = points[idx - 1]
            ans += maxOf(abs(curRow - prevRow), abs(curCol - prevCol))
        }

        return ans
    }
}