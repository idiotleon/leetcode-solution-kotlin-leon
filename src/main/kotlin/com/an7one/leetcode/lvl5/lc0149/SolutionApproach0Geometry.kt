/**
 * https://leetcode.com/problems/max-points-on-a-line/
 *
 * Time Complexity:     O(`totalPoints` ^ 2)
 * Space Complexity:    O(`totalPoints` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes/236567
 *  https://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes
 */
package com.an7one.leetcode.lvl5.lc0149

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Geometry {
    fun maxPoints(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0
        val totalPoints = points.size

        var ans = 0

        for (lo in points.indices) {
            val freqs = HashMap<String, Int>()
            var duplicate = 0
            var max = 0

            for (hi in lo + 1 until totalPoints) {
                val deltaX = points[hi][0] - points[lo][0]
                val deltaY = points[hi][1] - points[lo][1]

                if (deltaX == 0 && deltaY == 0) {
                    ++duplicate
                    continue
                }

                val gcd = gcd(deltaX, deltaY)
                val dX = deltaX / gcd
                val dY = deltaY / gcd

                val hash = "$dX#$dY"
                freqs[hash] = 1 + (freqs[hash] ?: 0)
                max = maxOf(max, freqs[hash] ?: 0)
            }

            ans = maxOf(ans, max + duplicate + 1)
        }

        return ans
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
}