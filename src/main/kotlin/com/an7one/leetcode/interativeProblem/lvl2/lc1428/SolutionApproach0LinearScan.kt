/**
 * https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 *
 * Time Complexity:     O(`nRows` + `nCols`) ~ O(maxOf(`nRows`, `nCols`))
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.interativeProblem.lvl2.lc1428

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@SuppressWarnings(UNUSED)
class SolutionApproach0LinearScan {
    fun leftMostColumnWithOne(binaryMatrix: FakeBinaryMatrix): Int {
        val (nRows, nCols) = binaryMatrix.dimensions()

        var row = 0
        var col = nCols - 1

        while (row < nRows && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                --col
            } else {
                ++row
            }
        }

        return if (col == nCols - 1) -1 else col + 1
    }
}