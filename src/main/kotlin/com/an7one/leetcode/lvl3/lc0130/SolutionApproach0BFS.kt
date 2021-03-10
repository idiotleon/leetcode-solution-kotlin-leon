/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/surrounded-regions/discuss/41649/My-BFS-solution-(C%2B%2B-28ms)
 */
package com.an7one.leetcode.lvl3.lc0130

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private const val LETTER_O = 'O'
        private const val LETTER_X = 'X'

        private const val LETTER_T = 'T'

        private val DIRS = intArrayOf(0, 1, 0, -1, 0)
    }

    fun solve(board: Array<CharArray>) {
        // sanity check, required
        if (board.isEmpty() || board[0].isEmpty()) return

        val nRows = board.size
        val nCols = board[0].size

        val queue = LinkedList<Coordinate>()

        for (row in board.indices) {
            if (board[row][0] == LETTER_O) {
                board[row][0] = LETTER_T
                queue.add(Coordinate(row, 0))
            }

            if (board[row][nCols - 1] == LETTER_O) {
                board[row][nCols - 1] = LETTER_T
                queue.add(Coordinate(row, nCols - 1))
            }
        }

        for (col in 1 until nCols - 1) {
            if (board[0][col] == LETTER_O) {
                board[0][col] = LETTER_T
                queue.add(Coordinate(0, col))
            }

            if (board[nRows - 1][col] == LETTER_O) {
                board[nRows - 1][col] = LETTER_T
                queue.add(Coordinate(nRows - 1, col))
            }
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val (curRow, curCol) = queue.poll()

                for (d in 0 until 4) {
                    val nextRow = curRow + DIRS[d]
                    val nextCol = curCol + DIRS[d + 1]

                    if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols || board[nextRow][nextCol] != LETTER_O) continue

                    board[nextRow][nextCol] = LETTER_T
                    queue.offer(Coordinate(nextRow, nextCol))
                }
            }
        }

        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == LETTER_O) board[row][col] = LETTER_X
                if (board[row][col] == LETTER_T) board[row][col] = LETTER_O
            }
        }
    }

    private data class Coordinate(val row: Int, val col: Int)
}