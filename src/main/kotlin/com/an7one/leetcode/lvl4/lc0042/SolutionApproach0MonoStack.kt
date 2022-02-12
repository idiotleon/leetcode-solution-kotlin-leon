package com.an7one.leetcode.lvl4.lc0042
import com.an7one.leetcode.util.Constant.Annotation.UNUSED
/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity:     O(`nHeights`)
 * Space Complexity:    O(`nHeights`)
 *
 * to maintain a "non-increasing" stack:
 *  1. to contain indexes, instead of heights/values
 *  2. to maintain a non-increasing order of heights in the stack
 *
 * in another word, the stack always keeps
 *  the (index of) left taller (compare to cur) column
 *
 * in another word, the `stack.last()` always has (the index of)
 *  the most immediate left taller column
 *
 * to keep checking out once an increase of height has been discovered,
 *  till the leftmost taller column (of the entire height array).
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    @OptIn(ExperimentalStdlibApi::class)
    fun trap(heights: IntArray): Int {
        // sanity check
        if (heights.isEmpty()) return 0

        val nHeights = heights.size
        val stack = ArrayDeque<Int>()

        var idx = 0
        var water = 0
        while (idx < nHeights) {
            if (stack.isEmpty() || heights[stack.last()] >= heights[idx]) {
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