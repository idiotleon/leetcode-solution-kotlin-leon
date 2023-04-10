/**
 * https://leetcode.com/problems/height-checker/
 *
 * Time Complexity:     O(`nHeights` * lg(`nHeights`))
 * Space Complexity:    O(`nHeights`)
 *
 * References:
 *  https://leetcode.com/problems/height-checker/discuss/299216/Java-Sort-1ms-O(nlogn)
 */
package com.idiotleon.leetcode.lvl1.lc1051

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun heightChecker(heights: IntArray): Int {
        // not used
        // val nHeights = heights.size

        val sorted = heights.sorted()

        var count = 0
        for (idx in heights.indices) {
            if (heights[idx] != sorted[idx])
                ++count
        }

        return count
    }
}