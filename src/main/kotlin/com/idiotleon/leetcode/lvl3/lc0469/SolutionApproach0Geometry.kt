/**
 * https://leetcode.com/problems/convex-polygon/
 *
 * Time Complexity:     O(`nPoints`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/convex-polygon/discuss/95584/java-easy-solution
 */
package com.idiotleon.leetcode.lvl3.lc0469

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Geometry {
    fun isConvex(points: List<List<Int>>): Boolean {
        var flag = 0
        for (idx in points.indices) {
            val angle = getAngle(idx, points)

            if (angle == 0) continue

            if (flag == 0) flag = if (angle > 0) 1 else -1
            else if (flag > 0 != angle > 0) return false
        }

        return true
    }

    private fun getAngle(idx: Int, points: List<List<Int>>): Int {
        val nPoints = points.size

        val vectorC = points[idx % nPoints]
        val vectorB = points[(idx + 1) % nPoints]
        val vectorA = points[(idx + 2) % nPoints]

        return (vectorA[1] - vectorB[1]) * (vectorB[0] - vectorC[0]) - (vectorB[1] - vectorC[1]) * (vectorA[0] - vectorB[0])
    }
}