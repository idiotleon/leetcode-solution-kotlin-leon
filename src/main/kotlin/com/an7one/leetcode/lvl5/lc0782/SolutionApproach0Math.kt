/**
 * https://leetcode.com/problems/transform-to-chessboard/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/transform-to-chessboard/discuss/114847/C%2B%2BJavaPython-Solution-with-Explanation
 *  https://leetcode.com/problems/transform-to-chessboard/discuss/132113/Java-Clear-Code-with-Detailed-Explanations
 */
package com.an7one.leetcode.lvl5.lc0782

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun movesToChessboard(board: Array<IntArray>): Int {
        val sideLen = board.size

        var sumRow = 0
        var sumCol = 0
        var swapRow = 0
        var swapCol = 0

        for (row in board.indices) {
            for (col in board[row].indices) {
                if ((board[0][0] xor board[row][0] xor board[0][col] xor board[row][col]) == 1) return -1
            }
        }

        for (idx in board.indices) {
            sumRow += board[0][idx]
            sumCol += board[idx][0]

            if (board[idx][0] == idx % 2) ++swapRow
            if (board[0][idx] == idx % 2) ++swapCol
        }

        if (sumRow != sideLen / 2 && sumRow != (sideLen + 1) / 2) return -1
        if (sumCol != sideLen / 2 && sumCol != (sideLen + 1) / 2) return -1

        if (sideLen % 2 == 1) {
            if (swapCol % 2 == 1) swapCol = sideLen - swapCol
            if (swapRow % 2 == 1) swapRow = sideLen - swapRow
        } else {
            swapCol = minOf(sideLen - swapCol, swapCol)
            swapRow = minOf(sideLen - swapRow, swapRow)
        }

        return (swapRow + swapCol) / 2
    }
}