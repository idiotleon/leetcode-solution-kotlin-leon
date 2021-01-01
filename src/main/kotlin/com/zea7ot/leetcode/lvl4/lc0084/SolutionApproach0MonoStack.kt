/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * to maintain a "non-decreasing" stack
 *  1. the content(s) of the `stack` is(are) index(es)
 *  2. the elements/heights, accessed by indexes, are non-decreasing
 *
 * please pay attention to `stack.pop()`, especially operations, with the `stack`, after that: the order matters
 *
 * References:
 *  https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/29018/AC-clean-Java-solution-using-stack
 */
package com.zea7ot.leetcode.lvl4.lc0084

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun largestRectangleArea(heights: IntArray): Int {
        // sanity check
        if (heights.isEmpty()) return 0

        val nHeights = heights.size
        var largest = 0

        val stack = LinkedList<Int>()

        var idx = 0
        while (idx < nHeights) {
            while (stack.isNotEmpty() && heights[idx] < heights[stack.peek()]) {
                // height of the concave
                val shortest = heights[stack.pop()]
                // current width
                val width = idx - if (stack.isEmpty()) 0 else (stack.peek() + 1)
                // current area
                val area = shortest * width
                largest = maxOf(largest, area)
            }

            stack.push(idx)
            ++idx
        }

        while (stack.isNotEmpty()) {
            // height of the concave
            val shortest = heights[stack.pop()]
            // current width
            val width = nHeights - if (stack.isEmpty()) 0 else (stack.peek() + 1)
            // current area
            val area = shortest * width
            largest = maxOf(largest, area)
        }

        return largest
    }
}