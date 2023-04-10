package com.idiotleon.leetcode.lvl4.lc0084

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * Reference:
 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack1 {
    fun largestRectangleArea(heights: IntArray): Int {
        // sanity check
        if (heights.isEmpty()) return 0

        val nHeights = heights.size
        var maxArea = 0

        val stack = ArrayDeque<Int>()
        var idx = 0

        while (idx <= nHeights) {
            val height = if (idx == nHeights) 0 else heights[idx]
            if (stack.isEmpty() || height >= heights[stack.last()]) {
                stack.addLast(idx++)
            } else {
                val top = stack.removeFirst()
                val width = if (stack.isEmpty()) idx else idx - 1 - stack.last()
                val area = width * heights[top]
                maxArea = maxOf(maxArea, area)
            }
        }

        return maxArea
    }
}