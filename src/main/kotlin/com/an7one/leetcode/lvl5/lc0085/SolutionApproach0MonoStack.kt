/**
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/maximal-rectangle/discuss/29064/A-O(n2)-solution-based-on-Largest-Rectangle-in-Histogram
 */
package com.an7one.leetcode.lvl5.lc0085

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    private companion object {
        private const val ONE = '1'
    }

    fun maximalRectangle(matrix: Array<CharArray>): Int {
        // sanity check
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0

        // not used
        // val nRows = matrix.size
        val nCols = matrix[0].size
        val heights = IntArray(nCols) { 0 }

        var max = 0

        for (row in matrix) {
            for ((idxCol, value) in row.withIndex()) {
                if (value == ONE) {
                    ++heights[idxCol]
                } else {
                    heights[idxCol] = 0
                }
            }

            max = maxOf(max, getMaxArea(heights))
        }

        return max
    }

    private fun getMaxArea(heights: IntArray): Int {
        val nHeights = heights.size

        val stack = ArrayDeque<Int>()
        var max = 0
        var idx = 0

        while (idx < nHeights) {
            while (stack.isNotEmpty() && heights[idx] < heights[stack.last()]){
                val shortest = heights[stack.removeLast()]
                val width = idx - if (stack.isEmpty()) 0 else (stack.last() + 1)
                val area = shortest * width
                max = maxOf(max, area)
            }

            stack.addLast(idx)
            ++idx
        }

        while (stack.isNotEmpty()) {
            val shortest = heights[stack.removeLast()]
            val width = nHeights - if (stack.isEmpty()) 0 else (stack.last() + 1)
            val area = shortest * width
            max = maxOf(max, area)
        }

        return max
    }
}