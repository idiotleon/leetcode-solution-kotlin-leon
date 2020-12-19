/**
 * https://leetcode.com/problems/range-sum-query-2d-mutable/
 *
 * Time Complexities:
 *  `update()`:         O(lg(`nRows` * `nCols`))
 *  `sumRegion()`:      O(lg(`nRows` * `nCols`))
 *
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms/79038
 *  https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms
 */
package com.zea7ot.leetcode.ood.lvl6.lc0308

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinaryIndexedTree(matrix: Array<IntArray>) {
    private val nRows = matrix.size
    private val nCols = if (matrix.isEmpty()) 0 else matrix[0].size

    private val nums = Array(nRows) { IntArray(nCols) { 0 } }
    private val fenwick = Array(nRows + 1) { IntArray(nCols + 1) { 0 } }

    init {
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                update(row, col, matrix[row][col])
            }
        }
    }

    fun update(row: Int, col: Int, value: Int) {
        if (nRows == 0 || nCols == 0) return
        val delta = value - nums[row][col]
        nums[row][col] = value

        var nextRow = row + 1

        while (nextRow <= nRows) {
            var nextCol = col + 1
            while (nextCol <= nCols) {
                fenwick[nextRow][nextCol] += delta
                nextCol += (nextCol and -nextCol)
            }

            nextRow += (nextRow and -nextRow)
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return sum(row1, col1) + sum(row2 + 1, col2 + 1) - sum(row1, col2 + 1) - sum(row2 + 1, col1)
    }

    private fun sum(row: Int, col: Int): Int {
        if (nRows == 0 || nCols == 0) return 0
        var sum = 0

        var nextRow = row
        while (nextRow > 0) {
            var nextCol = col
            while (nextCol > 0) {
                sum += fenwick[nextRow][nextCol]
                nextCol -= (nextCol and -nextCol)
            }
            nextRow -= (nextRow and -nextRow)
        }

        return sum
    }
}