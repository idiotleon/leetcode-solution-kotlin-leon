package com.an7one.leetcode.lvl4.lc1605

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 *
 * Time Complexity:     O(`nRows` * `nCols`) + O(`nRows` * lg(`nRows`)) + O(`nCols` * lg(`nCols`))
 * Space Complexity:    O(`nRows` * `nCols`) + O(`nRows`) + O(`nCols`)
 *
 * Reference:
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/discuss/876833/JavaPython-3-O(m-%2B-n)-codes-w-analysis%3A-Put-into-current-cell-the-less-of-the-remaining-values
 */
@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun restoreMatrix(rowSums: IntArray, colSums: IntArray): Array<IntArray> {
        val nRows = rowSums.size
        val nCols = colSums.size

        val matrix = Array(nRows) { IntArray(nCols) { 0 } }

        val rowMinHeap = PriorityQueue<Int>(compareBy { rowSums[it] }).also {
            for (idx in rowSums.indices) {
                it.offer(idx)
            }
        }
        val colMinHeap = PriorityQueue<Int>(compareBy { colSums[it] }).also {
            for (idx in colSums.indices) {
                it.offer(idx)
            }
        }

        while (rowMinHeap.isNotEmpty() && colMinHeap.isNotEmpty()) {
            val row = rowMinHeap.poll()
            val col = colMinHeap.poll()

            if (rowSums[row] < colSums[col]) {
                colSums[col] -= rowSums[row]
                matrix[row][col] = rowSums[row]
                colMinHeap.offer(col)
            } else {
                rowSums[row] -= colSums[col]
                matrix[row][col] = colSums[col]
                if (rowSums[row] > 0) {
                    rowMinHeap.offer(row)
                }
            }
        }

        return matrix
    }
}