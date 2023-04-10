package com.idiotleon.leetcode.lvl6.lc0587

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/erect-the-fence/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/erect-the-fence/discuss/103306/C++-and-Python-easy-wiki-solution/617487
 * https://leetcode.com/problems/erect-the-fence/discuss/103306/C%2B%2B-and-Python-easy-wiki-solution
 */
@Suppress(UNUSED)
class SolutionApproach0ConvexHull {
    fun outerTrees(points: Array<IntArray>): Array<IntArray> {
        points.sortWith(compareBy({ -it[0] }, { -it[1] }))

        // to hold the vertices of upper and lower hulls
        val hull = LinkedList<IntArray>()

        for (idx in points.indices) {
            while (hull.size >= 2 && getOrientation(hull[0], hull[1], points[idx]) > 0) {

                hull.pop()
            }

            hull.push(points[idx])
        }

        hull.pop()

        for (idx in points.indices.reversed()) {
            while (hull.size >= 2 && getOrientation(hull[0], hull[1], points[idx]) > 0) {
                hull.pop()
            }

            hull.push(points[idx])
        }

        return hull.toSet().toTypedArray()
    }

    private fun getOrientation(p: IntArray, q: IntArray, r: IntArray) =
        ((q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]))
}