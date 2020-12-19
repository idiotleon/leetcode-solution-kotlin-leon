/**
 * https://leetcode.com/problems/largest-triangle-area/
 *
 * Time Complexity:     O(`nPts` ^ 3)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/largest-triangle-area/discuss/124010/Simple-Java-Easy-Understand
 *  https://www.mathopenref.com/coordtrianglearea.html
 *  https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 *  https://leetcode.com/problems/largest-triangle-area/discuss/122711/C%2B%2BJavaPython-Solution-with-Explanation-and-Prove
 */
package com.zea7ot.leetcode.lvl3.lc0812

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0Geometry {
    fun largestTriangleArea(points: Array<IntArray>): Double {
        val nPts = points.size

        var max = 0.0

        for (i in 0 until nPts - 2) {
            for (j in i + 1 until nPts - 1) {
                for (k in j + 1 until nPts) {
                    max = maxOf(max, getArea(points[i], points[j], points[k]))
                }
            }
        }

        return max
    }

    private fun getArea(coord0: IntArray, coord1: IntArray, coord2: IntArray) =
        abs(coord0[0] * (coord1[1] - coord2[1]) + coord1[0] * (coord2[1] - coord0[1]) + coord2[0] * (coord0[1] - coord1[1])) / 2.0
}