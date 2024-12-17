package com.idiotleon.leetcode.lvl4.lc0042

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity:     O(`nHeights`)
 * Space Complexity:    O(`nHeights`)
 *
 * To maintain a "non-increasing" stack:
 *  1. To contain indexes, instead of heights/values
 *  2. To maintain a non-increasing order of heights in the stack
 *
 * In another word, the stack always keeps
 *  the (index of) left taller (compare to cur) column
 *
 * In another word, the `stack.last()` always has (the index of)
 *  the most immediate left taller column
 *
 * To keep checking out once an increase of height has been discovered,
 *  till the leftmost taller column (of the entire height array).
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun trap(heights: IntArray): Int {
        if (heights.isEmpty()) {
            return 0
        }

        val nHeights = heights.size
        val stack = ArrayDeque<Int>(nHeights)

        var idx = 0
        var water = 0
        while (idx < nHeights) {
            if (stack.isEmpty() || heights[idx] <= heights[stack.last()]) {
                stack.addLast(idx)
                ++idx
            } else {
                val idxConcave = stack.removeLast()
                if (stack.isNotEmpty()) {
                    val minHeight = minOf(heights[idx], heights[stack.last()])
                    water += (minHeight - heights[idxConcave]) * (idx - stack.last() - 1)
                }
            }
        }

        return water
    }
}