/**
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 *
 * Time Complexity:     O(`totalRows` * `totalCols`) + O(`totalRows` * lg(`totalRows`)) + O(`totalCols` * lg(`totalCols`))
 * Space Complexity:    O(`totalRows` * `totalCols`) + O(`totalRows`) + O(`totalCols`)
 *
 * References:
 *  https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/discuss/876833/JavaPython-3-O(m-%2B-n)-codes-w-analysis%3A-Put-into-current-cell-the-less-of-the-remaining-values
 */
package com.zea7ot.leetcode.lvl4.lc1605

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun restoreMatrix(rowSums: IntArray, colSums: IntArray): Array<IntArray> {
        val totalRows = rowSums.size
        val totalCols = colSums.size

        val matrix = Array(totalRows) { IntArray(totalCols) { 0 } }

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