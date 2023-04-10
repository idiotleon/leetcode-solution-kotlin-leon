/**
 * @author: Leon
 * https://leetcode.com/problems/01-matrix/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
package com.idiotleon.leetcode.lvl3.lc0542

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
        private const val RANGE_DATA = 1e4.toInt() + 7
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val nRows = matrix.size
        val nCols = matrix[0].size

        val queue = ArrayDeque<Cell>()
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                if (matrix[row][col] == 0)
                    queue.addLast(Cell(row, col))
                else
                    matrix[row][col] = RANGE_DATA
            }
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val (row, col) = queue.removeFirst()

                for (d in 0 until 4) {
                    val nextRow = row + DIRS[d]
                    val nextCol = col + DIRS[d + 1]

                    if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols || matrix[nextRow][nextCol] != RANGE_DATA)
                        continue

                    matrix[nextRow][nextCol] = 1 + matrix[row][col]
                    queue.addLast(Cell(nextRow, nextCol))
                }
            }
        }

        return matrix
    }

    private data class Cell(val row: Int, val col: Int)
}