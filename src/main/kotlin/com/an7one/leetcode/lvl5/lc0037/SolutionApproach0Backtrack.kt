/**
 * https://leetcode.com/problems/sudoku-solver/
 *
 * Time Complexity:     O(`RANGE` ^ EMPTY_CELLS(`board`))
 * Space Complexity:    O()
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485097&idx=1&sn=a5e82da8646cd8985de6b2b0950de4e2&chksm=9bd7f8a1aca071b7b72e23013bc2a7c528ee913fded9278e2058bc98d7c746e439737d7abb5b&scene=178&cur_album_id=1318883740306948097#rd
 */
package com.an7one.leetcode.lvl5.lc0037

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private const val RANGE = 9
        private const val EMPTY = '.'
    }

    fun solveSudoku(board: Array<CharArray>) {
        backtrack(0, 0, board)
    }

    private fun backtrack(curRow: Int, curCol: Int, board: Array<CharArray>): Boolean {
        // to move to the next row
        if (curCol == RANGE)
            return backtrack(curRow + 1, 0, board)

        // to terminate with an eligible case
        if (curRow == RANGE)
            return true

        for (row in curRow until RANGE) {
            for (col in curCol until RANGE) {
                // if it has been visited/set before
                if (board[row][col] != EMPTY)
                    return backtrack(row, col + 1, board)

                for (digit in '1'..'9') {
                    if (!isValid(row, col, digit, board))
                        continue

                    board[row][col] = digit
                    if (backtrack(row, col + 1, board))
                        return true

                    board[row][col] = EMPTY
                }

                return false
            }
        }

        return false
    }

    private fun isValid(
        row: Int,
        col: Int,
        numCh: Char,
        board: Array<CharArray>
    ): Boolean {
        for (idx in 0 until RANGE) {
            // to check rows
            if (board[row][idx] == numCh)
                return false

            // to check cols
            if (board[idx][col] == numCh)
                return false

            // to check 3 x 3 square
            if (board[row / 3 * 3 + idx / 3][col / 3 * 3 + idx % 3] == numCh)
                return false
        }

        return true
    }
}