/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity:     O(`totalHeights`)
 * Space Complexity:    O(`totalHeights`)
 */
package com.zea7ot.leetcode.lvl4.lc0042

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun trap(heights: IntArray): Int {
        val totalHeights = heights.size

        val leftMax = IntArray(totalHeights)
        for (idx in 0 until totalHeights) {
            leftMax[idx] = if (idx == 0) {
                heights[idx]
            } else {
                maxOf(leftMax[idx - 1], heights[idx])
            }
        }

        val rightMax = IntArray(totalHeights)
        for (idx in totalHeights - 1 downTo 0) {
            rightMax[idx] = if (idx == totalHeights - 1) {
                heights[totalHeights - 1]
            } else {
                maxOf(heights[idx], rightMax[idx + 1])
            }
        }

        var water = 0
        for (idx in 0 until totalHeights) {
            water += minOf(leftMax[idx], rightMax[idx]) - heights[idx]
        }

        return water
    }
}