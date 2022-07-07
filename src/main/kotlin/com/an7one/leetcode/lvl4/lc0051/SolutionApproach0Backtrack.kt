package com.an7one.leetcode.lvl4.lc0051

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/n-queens/
 *
 * Time Complexity:     O(`n`!)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=178&cur_album_id=1318883740306948097#rd
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private const val QUEEN = 'Q'
        private const val EMPTY = '.'
    }

    fun solveNQueens(n: Int): List<List<String>> {
        val ans = mutableListOf<List<String>>()

        val isSameColumn = BooleanArray(n) { false }
        val isSameMainDiagonal = BooleanArray(2 * n - 1) { false }
        val isSameAntidiagonal = BooleanArray(2 * n - 1) { false }

        val board = Array(n) { CharArray(n) { EMPTY } }

        backtrack(0, isSameColumn, isSameMainDiagonal, isSameAntidiagonal, board, ans)

        return ans
    }

    private fun backtrack(
        row: Int,
        isSameColumn: BooleanArray,
        isSameMainDiagonal: BooleanArray,
        isSameAntidiagonal: BooleanArray,
        board: Array<CharArray>,
        res: MutableList<List<String>>
    ) {
        val sideLen = board.size
        if (row == sideLen) {
            res.add(construct(board))
            return
        }

        for (col in board[row].indices) {
            if (isSameColumn[col] || isSameMainDiagonal[row + sideLen - col - 1] || isSameAntidiagonal[row + col]) continue

            // to further backtrack to the next state
            isSameColumn[col] = true
            isSameMainDiagonal[row + sideLen - col - 1] = true
            isSameAntidiagonal[row + col] = true
            board[row][col] = QUEEN

            backtrack(1 + row, isSameColumn, isSameMainDiagonal, isSameAntidiagonal, board, res)

            // to backtrack to the previous state
            isSameColumn[col] = false
            isSameMainDiagonal[row + sideLen - col - 1] = false
            isSameAntidiagonal[row + col] = false
            board[row][col] = EMPTY
        }
    }

    private fun construct(board: Array<CharArray>): List<String> {
        val ans = mutableListOf<String>()

        for (row in board) {
            ans.add(row.joinToString(""))
        }

        return ans
    }
}