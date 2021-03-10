/**
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 *
 * Time Complexity:     O(`nPos`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/discuss/398178/Detailed-Explanation-O(n)-or-O(1)-Everything-is-in-0-or-1/358490
 */
package com.an7one.leetcode.lvl2.lc1217

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun minCostToMoveChips(positions: IntArray): Int {
        // not used
        // val nPos = positions.size

        var odd = 0
        var even = 0

        for (pos in positions) {
            if (pos % 2 == 0) ++even
            else ++odd
        }

        return minOf(even, odd)
    }
}