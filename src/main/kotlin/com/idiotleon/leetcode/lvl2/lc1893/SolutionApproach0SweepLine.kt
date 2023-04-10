/**
 * https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 *
 * Time Complexity:     O(`RANGE_DATA`)
 * Space Complexity:    O(`RANGE_DATA`) / O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/discuss/1267923/Line-Sweep-O(n-%2B-m)
 */
package com.idiotleon.leetcode.lvl2.lc1893

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SweepLine {
    private companion object {
        private const val RANGE_DATA = 50 + 7
    }

    fun isCovered(ranges: Array<IntArray>, left: Int, right: Int): Boolean {
        val timeline = IntArray(RANGE_DATA) { 0 }
        for ((lo, hi) in ranges) {
            ++timeline[lo]
            --timeline[hi + 1]
        }

        var overlaps = 0
        for (idx in 1..right) {
            overlaps += timeline[idx]

            if (idx >= left && overlaps == 0)
                return false
        }

        return true
    }
}