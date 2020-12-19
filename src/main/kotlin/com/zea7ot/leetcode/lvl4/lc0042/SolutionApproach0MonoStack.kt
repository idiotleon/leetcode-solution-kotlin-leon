/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * to maintain a "non-increasing" stack:
 *  1. to contain indexes, instead of heights/values
 *  2. to maintain a non-increasing order of heights in the stack
 *
 * in another word, the stack always keeps
 *  the (index of) left taller (compare to cur) column
 *
 * in another word, the `stack.peek()` always has (the index of)
 *  the most immediate left taller column
 *
 * to keep checking out once an increase of height has been discovered,
 *  till the leftmost taller column (of the entire height array).
 */
package com.zea7ot.leetcode.lvl4.lc0042

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.LinkedList

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun trap(heights: IntArray): Int {
        // sanity check
        if (heights.isEmpty()) return 0

        val totalHeights = heights.size
        val stack = LinkedList<Int>()

        var idx = 0
        var water = 0
        while (idx < totalHeights) {
            if (stack.isEmpty() || heights[stack.peek()] >= heights[idx]) {
                stack.push(idx)
                ++idx
            } else {
                val idxConcave = stack.pop()
                if (stack.isNotEmpty()) {
                    val minHeight = minOf(heights[idx], heights[stack.peek()])
                    water += (minHeight - heights[idxConcave]) * (idx - stack.peek() - 1)
                }
            }
        }

        return water
    }
}