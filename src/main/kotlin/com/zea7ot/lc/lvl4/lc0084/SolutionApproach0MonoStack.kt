/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * to maintain a "non-decreasing" stack
 *  1. the content(s) of the `stack` is(are) index(es)
 *  2. the elements/heights, accessed by indexes, are non-descreasing
 *
 * please pay attention to `stack.pop()`, especially operations on the `stack` after that: the oder matters
 *
 * References:
 *  https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/29018/AC-clean-Java-solution-using-stack
 */
package com.zea7ot.lc.lvl4.lc0084

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun largestRectangleArea(heights: IntArray): Int {
        // sanity check
        if (heights.isEmpty()) return 0

        val size = heights.size
        var idx = 0
        var max = 0

        val stack = LinkedList<Int>()

        while (idx < size) {
            while (stack.isNotEmpty() && heights[idx] < heights[stack.peek()]) {
                val idxConcave = stack.pop()
                val width = idx - if (stack.isEmpty()) 0 else (stack.peek() + 1)
                val area = heights[idxConcave] * width
                max = maxOf(max, area)
            }

            stack.push(idx)
            ++idx
        }

        while (stack.isNotEmpty()) {
            val idxConcave = stack.pop()
            val width = size - if (stack.isEmpty()) 0 else (stack.peek() + 1)
            val area = heights[idxConcave] * width
            max = maxOf(max, area)
        }

        return max
    }
}