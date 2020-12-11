/**
 * https://leetcode.com/problems/dungeon-game/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *  or O(1) if one modifying the original array
 *
 * References:
 *  https://leetcode.com/problems/dungeon-game/discuss/52774/C%2B%2B-DP-solution
 *  https://leetcode.com/problems/dungeon-game/discuss/52774/C++-DP-solution/53813
 */
package com.zea7ot.leetcode.lvl4.lc0174

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val nRows = dungeon.size
        val nCols = dungeon[0].size

        val dp = Array(nRows + 1) { IntArray(nCols + 1) { Int.MAX_VALUE } }
        dp[nRows][nCols - 1] = 1
        dp[nRows - 1][nCols] = 1

        for (row in nRows - 1 downTo 0) {
            for (col in nCols - 1 downTo 0) {
                val need = minOf(dp[row + 1][col], dp[row][col + 1]) - dungeon[row][col]

                dp[row][col] = if (need <= 0) 1 else need
            }
        }

        return dp[0][0]
    }
}