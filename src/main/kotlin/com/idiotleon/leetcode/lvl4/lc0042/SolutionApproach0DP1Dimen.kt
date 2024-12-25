package com.idiotleon.leetcode.lvl4.lc0042

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

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

        val loMax = IntArray(nHeights) { 0 }.also {
            for (idx in 0 until nHeights) {
                it[idx] = if (idx == 0) {
                    heights[idx]
                } else {
                    maxOf(it[idx - 1], heights[idx])
                }
            }
        }

        val hiMax = IntArray(nHeights) { 0 }.also {
            for (idx in nHeights - 1 downTo 0) {
                it[idx] = if (idx == heights.lastIndex) {
                    heights.last()
                } else {
                    maxOf(heights[idx], it[idx + 1])
                }
            }
        }

        var water = 0
        for (idx in 0 until nHeights) {
            water += minOf(loMax[idx], hiMax[idx]) - heights[idx]
        }
        return water
    }
}