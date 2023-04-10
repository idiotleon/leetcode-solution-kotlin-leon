/**
 * https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 *
 * Time Complexity:     O(`nRows` * lg(`nCols`))
 * Space Complexity:    O(1)
 */
package com.idiotleon.leetcode.lvl2.lc1428

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun leftMostColumnWithOne(binaryMatrix: FakeBinaryMatrix): Int {
        val (nRows, nCols) = binaryMatrix.dimensions()

        var min = Int.MAX_VALUE
        for (row in 0 until nRows) {
            var lo = 0
            var hi = nCols - 1

            while (lo < hi) {
                val mid = lo + (hi - lo) / 2

                if (binaryMatrix.get(row, mid) == 1)
                    hi = mid
                else
                    lo = mid + 1
            }

            if (binaryMatrix.get(row, lo) == 1)
                min = minOf(min, lo)
        }

        return if (min == Int.MAX_VALUE) -1 else min
    }
}