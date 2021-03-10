/**
 * https://leetcode.com/problems/rectangle-overlap/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/rectangle-overlap/discuss/132340/C%2B%2BJavaPython-1-line-Solution-1D-to-2D
 */
package com.an7one.leetcode.lvl2.lc0836

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Geometry {
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        if (rec1[0] == rec1[2] // rect1 is a horizontal line segment
            || rec2[0] == rec2[2] // rect2 is a horizontal line segment
            || rec1[1] == rec1[3] // rect1 is a horizontal line segment
            || rec2[1] == rec2[3]
        ) // rect2 is a horizontal line segment
            return false

        return rec1[2] > rec2[0] // left
                && rec1[3] > rec2[1] // bottom
                && rec1[0] < rec2[2] // right
                && rec1[1] < rec2[3] // top
    }
}