package com.idiotleon.leetcode.lvl3.lc0807

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows`) + O(`nCols`) ~ O(max(`nRows`, `nCols`))
 *
 * Reference:
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/discuss/120681/C%2B%2BJavaPython-Easy-and-Concise-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val rowMaxes = IntArray(nRows) { 0 }
        val colMaxes = IntArray(nCols) { 0 }

        for (row in grid.indices) {
            for (col in grid[0].indices) {
                rowMaxes[row] = maxOf(rowMaxes[row], grid[row][col])
                colMaxes[col] = maxOf(colMaxes[col], grid[row][col])
            }
        }

        var maxInc = 0
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                maxInc += minOf(rowMaxes[row], colMaxes[col]) - grid[row][col]
            }
        }

        return maxInc
    }
}