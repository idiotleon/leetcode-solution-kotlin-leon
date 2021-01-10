/**
 * https://leetcode.com/problems/circle-and-rectangle-overlapping/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/circle-and-rectangle-overlapping/discuss/563441/JAVA-compare-distance-between-radius-and-closest-point-on-rectangle-to-circle
 */
package com.zea7ot.leetcode.lvl3.lc1401

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Geometry {
    fun checkOverlap(
        radius: Int,
        xCenter: Int,
        yCenter: Int,
        x1: Int,
        y1: Int,
        x2: Int,
        y2: Int
    ): Boolean {

        val closestX = maxOf(x1, minOf(xCenter, x2))
        val closestY = maxOf(y1, minOf(yCenter, y2))

        val distanceX = xCenter - closestX
        val distanceY = yCenter - closestY

        val distance = (distanceX * distanceX) + (distanceY * distanceY)
        return distance <= radius * radius
    }
}