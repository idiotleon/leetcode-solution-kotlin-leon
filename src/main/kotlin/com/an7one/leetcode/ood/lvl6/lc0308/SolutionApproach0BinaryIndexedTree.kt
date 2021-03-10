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
package com.an7one.leetcode.ood.lvl6.lc0308

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

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

        // to turn into the index for BIT
        var idxRow = 1 + row

        while (idxRow <= nRows) {
            // to turn into the index for BIT
            var idxCol = 1 + col
            while (idxCol <= nCols) {
                fenwick[idxRow][idxCol] += delta
                idxCol += (idxCol and -idxCol)
            }

            idxRow += (idxRow and -idxRow)
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return querySum(row1 - 1, col1 - 1) + querySum(row2, col2) - querySum(row1 - 1, col2) - querySum(row2, col1 - 1)
    }

    private fun querySum(row: Int, col: Int): Int {
        if (nRows == 0 || nCols == 0) return 0
        var sum = 0

        // to turn into the index for BIT
        var idxRow = 1 + row
        while (idxRow > 0) {
            // to turn into the index for BIT
            var idxCol = 1 + col
            while (idxCol > 0) {
                sum += fenwick[idxRow][idxCol]
                idxCol -= (idxCol and -idxCol)
            }
            idxRow -= (idxRow and -idxRow)
        }

        return sum
    }
}