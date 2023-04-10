/**
 * https://leetcode.com/problems/height-checker/
 *
 * Time Complexity:     O(max(`heights`)) + O(`nHeights`)
 * Space Complexity:    O(`RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/height-checker/discuss/300472/Java-0ms-O(n)-solution-no-need-to-sort
 */
package com.idiotleon.leetcode.lvl1.lc1051

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CountingSort {
    private companion object {
        private const val RANGE = 100 + 7
    }

    fun heightChecker(heights: IntArray): Int {
        // not used
        // val nHeights = heights.size

        val freqs = IntArray(RANGE) { 0 }
        for (height in heights) {
            ++freqs[height]
        }

        var count = 0
        var curHeight = 0

        for (idx in heights.indices) {
            while (freqs[curHeight] == 0) {
                ++curHeight
            }

            if (curHeight != heights[idx])
                ++count

            --freqs[curHeight]
        }

        return count
    }
}