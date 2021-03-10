/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 *
 * Time Complexity:     O(`nRows` * `nCols` * lg(`nRows` * `nCols`))
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/sort-the-matrix-diagonally/discuss/489749/JavaPython-Straight-Forward
 */
package com.an7one.leetcode.lvl3.lc1329

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun diagonalSort(matrix: Array<IntArray>): Array<IntArray> {
        // not used
        // val nRows = matrix.size
        // val nCols = matrix[0].size

        val map = HashMap<Int, PriorityQueue<Int>>()
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                map.getOrPut(row - col) { PriorityQueue() }.add(matrix[row][col])
            }
        }

        for (row in matrix.indices) {
            for (col in matrix[0].indices) {
                matrix[row][col] = map[row - col]!!.poll()
            }
        }

        return matrix
    }
}