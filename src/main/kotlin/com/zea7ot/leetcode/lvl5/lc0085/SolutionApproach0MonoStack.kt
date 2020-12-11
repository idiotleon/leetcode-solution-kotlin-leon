/**
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Time Complexity:     O(`numRows` * `numCols`)
 * Space Complexity:    O(`numRows` * `numCols`)
 *
 * References:
 *  https://leetcode.com/problems/maximal-rectangle/discuss/29064/A-O(n2)-solution-based-on-Largest-Rectangle-in-Histogram
 */
package com.zea7ot.leetcode.lvl5.lc0085

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    private companion object {
        private const val ONE = '1'
    }

    fun maximalRectangle(matrix: Array<CharArray>): Int {
        // sanity check
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0

        val numRows = matrix.size
        val numCols = matrix[0].size
        val heights = IntArray(numCols) { 0 }

        var max = 0

        for (row in 0 until numRows) {
            for (col in 0 until numCols) {
                if (matrix[row][col] == ONE) {
                    ++heights[col]
                } else {
                    heights[col] = 0
                }
            }

            max = maxOf(max, getMaxArea(heights))
        }

        return max
    }

    private fun getMaxArea(heights: IntArray): Int {
        val totalHeights = heights.size

        val stack = LinkedList<Int>()
        var max = 0
        var idx = 0

        while (idx < totalHeights) {
            while (stack.isNotEmpty() && heights[idx] < heights[stack.peek()]) {
                val shortest = heights[stack.pop()]
                val width = idx - if (stack.isEmpty()) 0 else (stack.peek() + 1)
                val area = shortest * width
                max = maxOf(max, area)
            }

            stack.push(idx)
            ++idx
        }

        while (stack.isNotEmpty()) {
            val shortest = heights[stack.pop()]
            val width = totalHeights - if (stack.isEmpty()) 0 else (stack.peek() + 1)
            val area = shortest * width
            max = maxOf(max, area)
        }

        return max
    }
}