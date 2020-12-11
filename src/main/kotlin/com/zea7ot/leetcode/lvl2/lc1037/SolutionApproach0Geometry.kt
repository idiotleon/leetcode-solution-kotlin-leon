/**
 * https://leetcode.com/problems/valid-boomerang/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/valid-boomerang/discuss/286702/JavaC%2B%2BPython-Straight-Forward
 */
package com.zea7ot.leetcode.lvl2.lc1037

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Geometry {
    fun isBoomerang(points: Array<IntArray>): Boolean {
        val (pt0, pt1, pt2) = points

        return (pt0[0] - pt1[0]) * (pt0[1] - pt2[1]) != (pt0[0] - pt2[0]) * (pt0[1] - pt1[1])
    }
}