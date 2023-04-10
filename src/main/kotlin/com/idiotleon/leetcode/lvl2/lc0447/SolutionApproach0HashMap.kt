package com.idiotleon.leetcode.lvl2.lc0447

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-boomerangs/
 *
 * Time Complexity:     O(`nPoints` ^ 2)
 * Space Complexity:    O(`nPoints`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-boomerangs/discuss/126604/For-people-who-don't-know-why-we-need-this-line%3A-res-%2B-val-*-(val-1)
 *  https://leetcode.com/problems/number-of-boomerangs/discuss/92868/Short-Python-O(n2)-hashmap-solution/113268
 *  https://leetcode.com/problems/number-of-boomerangs/discuss/92861/Clean-java-solution%3A-O(n2)-166ms
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        // not used
        // val nPoints = points.size

        var count = 0

        val distanceToFreq = HashMap<Int, Int>()
        for (idx1 in points.indices) {
            for (idx2 in points.indices) {
                if (idx1 == idx2) continue

                val distance = getDistance(points[idx1], points[idx2])
                distanceToFreq[distance] = 1 + (distanceToFreq[distance] ?: 0)
            }

            for ((_, freq) in distanceToFreq) {
                count += freq * (freq - 1)
            }

            distanceToFreq.clear()
        }

        return count
    }

    private fun getDistance(point1: IntArray, point2: IntArray): Int {
        val dx = point1[0] - point2[0]
        val dy = point1[1] - point2[1]

        return dx * dx + dy * dy
    }
}