/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity:     O(`totalHeights`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution./185869
 *  https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
 */
package com.zea7ot.leetcode.lvl4.lc0042

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun trap(heights: IntArray): Int {
        val totalHeights = heights.size

        var lo = 0
        var hi = totalHeights - 1
        var loMax = Int.MIN_VALUE
        var hiMax = Int.MIN_VALUE
        var water = 0

        while (lo <= hi) {
            loMax = maxOf(loMax, heights[lo])
            hiMax = maxOf(hiMax, heights[hi])

            if (loMax < hiMax) {
                water += loMax - heights[lo]
                ++lo
            } else {
                water += hiMax - heights[hi]
                --hi
            }
        }

        return water
    }
}