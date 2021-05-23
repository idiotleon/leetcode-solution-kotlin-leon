/**
 * https://leetcode.com/problems/design-tic-tac-toe/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(`n`)
 *
 * Reference:
 *  https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand
 */
package com.an7one.leetcode.ood.lvl3.lc0348

import kotlin.math.abs

class SolutionApproach0LinearScan(private val n: Int) {
    private val rows = IntArray(n) { 0 }
    private val cols = IntArray(n) { 0 }
    private var diagonal = 0
    private var antiDiagonal = 0

    fun move(row: Int, col: Int, player: Int): Int {
        val toAdd = if (player == 1) 1 else -1

        rows[row] += toAdd
        cols[col] += toAdd

        if (row == col)
            diagonal += toAdd

        if (col == n - row - 1)
            antiDiagonal += toAdd

        if (abs(rows[row]) == n
            || abs(cols[col]) == n
            || abs(diagonal) == n
            || abs(antiDiagonal) == n
        )
            return player

        return 0
    }
}