package com.idiotleon.leetcode.lvl4.lc0042

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity:     O(`nHeights`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution./185869
 *  https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun trap(heights: IntArray): Int {
        val nHeights = heights.size

        var lo = 0
        var hi = nHeights - 1
        var loMax = 0
        var hiMax = 0
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