/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
 */
package com.zea7ot.leetcode.lvl4.lc0084

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack1 {
    fun largestRectangleArea(heights: IntArray): Int {
        // sanity check
        if (heights.isEmpty()) return 0

        val size = heights.size
        var maxArea = 0

        val stack = LinkedList<Int>()
        var idx = 0

        while (idx <= size) {
            val height = if (idx == size) 0 else heights[idx]
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(idx++)
            } else {
                val top = stack.pop()
                val width = if (stack.isEmpty()) idx else idx - 1 - stack.peek()
                val area = width * heights[top]
                maxArea = maxOf(maxArea, area)
            }
        }

        return maxArea
    }
}