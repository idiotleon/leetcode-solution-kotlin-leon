package com.an7one.leetcode.lvl4.lc0042

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity:     O(`nHeights`)
 * Space Complexity:    O(`nHeights`)
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun trap(heights: IntArray): Int {
        val nHeights = heights.size

        val leftMax = IntArray(nHeights)
        for (idx in 0 until nHeights) {
            leftMax[idx] = if (idx == 0) {
                heights[idx]
            } else {
                maxOf(leftMax[idx - 1], heights[idx])
            }
        }

        val rightMax = IntArray(nHeights)
        for (idx in nHeights - 1 downTo 0) {
            rightMax[idx] = if (idx == nHeights - 1) {
                heights[nHeights - 1]
            } else {
                maxOf(heights[idx], rightMax[idx + 1])
            }
        }

        var water = 0
        for (idx in 0 until nHeights) {
            water += minOf(leftMax[idx], rightMax[idx]) - heights[idx]
        }

        return water
    }
}