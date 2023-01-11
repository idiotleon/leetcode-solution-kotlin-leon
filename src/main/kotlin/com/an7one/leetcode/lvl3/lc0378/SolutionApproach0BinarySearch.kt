package com.an7one.leetcode.lvl3.lc0378

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * Time Complexity:     O(`nCols` * (max - min))
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val nRows = matrix.size
        val nCols = matrix[0].size

        var lo = matrix[0][0]
        var hi = matrix[nRows - 1][nCols - 1]

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            val count = getCount(matrix, mid)

            if (count >= k) hi = mid
            else lo = mid + 1
        }

        return lo
    }

    private fun getCount(matrix: Array<IntArray>, target: Int): Int {
        val nRows = matrix.size
        val nCols = matrix[0].size

        var count = 0

        var row = 0
        var col = nCols - 1

        while (row < nRows) {
            while (col >= 0 && matrix[row][col] > target) {
                --col
            }

            count += (col + 1)

            ++row
        }

        return count
    }
}