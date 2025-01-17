package com.idiotleon.leetcode.lvl3.lc0036

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Time Complexity:     O(9 * 9)
 * Space Complexity:    O(9 * 9)
 *
 * References:
 *  https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code/15493
 *  https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    private companion object {
        private const val EMPTY = '.'
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (row in board.indices) {
            val seenInRow = HashSet<Char>()
            val seenInCol = HashSet<Char>()
            val seenInCube = HashSet<Char>()

            for (col in board[row].indices) {
                if (board[row][col] != EMPTY && !seenInRow.add(board[row][col])) {
                    return false
                }

                if (board[col][row] != EMPTY && !seenInCol.add(board[col][row])) {
                    return false
                }

                val idxRow = 3 * (row / 3)
                val idxCol = 3 * (row % 3)

                if (board[idxRow + col / 3][idxCol + col % 3] != EMPTY && !seenInCube.add(board[idxRow + col / 3][idxCol + col % 3])) {
                    return false
                }
            }
        }

        return true
    }
}