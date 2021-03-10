/**
 * https://leetcode.com/problems/n-queens/
 *
 * Time Complexity:     O(2 ^ (`n` ^ 2))
 * Space Complexity:    O()
 *
 * this approach is based on whether a queen is going to be placed on a grid or not
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/21/
 */
package com.an7one.leetcode.lvl4.lc0051

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1Backtrack {
    private companion object {
        private const val QUEEN = 'Q'
        private const val EMPTY = '.'
    }

    fun solveNQueens(n: Int): List<List<String>> {
        val ans = mutableListOf<List<String>>()

        val isSameRow = BooleanArray(n) { false }
        val isSameColumn = BooleanArray(n) { false }
        val isSameMainDiagonal = BooleanArray(2 * n - 1) { false }
        val isSameAntidiagonal = BooleanArray(2 * n - 1) { false }

        val board = Array(n) { CharArray(n) { EMPTY } }

        backtrack(0, 0, 0, isSameRow, isSameColumn, isSameMainDiagonal, isSameAntidiagonal, board, n, ans)

        return ans
    }

    private fun backtrack(
        row: Int,
        col: Int,
        cntQueens: Int,
        isSameRow: BooleanArray,
        isSameColumn: BooleanArray,
        isSameMainDiagonal: BooleanArray,
        isSameAntidiagonal: BooleanArray,
        board: Array<CharArray>,
        nQueens: Int,
        res: MutableList<List<String>>
    ) {
        val sideLen = board.size

        var row = row
        var col = col

        // to move to the start position of the next row
        if (col == sideLen) {
            col = 0
            ++row
        }

        if (row == sideLen) {
            if (cntQueens == nQueens) res.add(construct(board))

            return
        }

        // not to place the `QUEEN` here
        backtrack(
            row,
            col + 1,
            cntQueens,
            isSameRow,
            isSameColumn,
            isSameMainDiagonal,
            isSameAntidiagonal,
            board,
            nQueens,
            res
        )

        // to place the `QUEEN` here
        if (isSameRow[row] || isSameColumn[col] || isSameMainDiagonal[row - col + sideLen - 1] || isSameAntidiagonal[row + col]) return
        // to further backtrack to the next state
        board[row][col] = QUEEN
        isSameRow[row] = true
        isSameColumn[col] = true
        isSameMainDiagonal[row - col + sideLen - 1] = true
        isSameAntidiagonal[row + col] = true
        backtrack(
            row, col + 1, cntQueens + 1, isSameRow,
            isSameColumn,
            isSameMainDiagonal,
            isSameAntidiagonal,
            board,
            nQueens,
            res
        )

        // to backtrack to the previous state
        board[row][col] = EMPTY
        isSameRow[row] = false
        isSameColumn[col] = false
        isSameMainDiagonal[row - col + sideLen - 1] = false
        isSameAntidiagonal[row + col] = false
    }

    private fun construct(board: Array<CharArray>): List<String> {
        val ans = mutableListOf<String>()

        for (row in board) {
            ans.add(row.joinToString(""))
        }

        return ans
    }
}