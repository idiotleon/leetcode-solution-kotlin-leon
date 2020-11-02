/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 *
 * Time Complexity:     O(`totalRows` * `totalCols`)
 * Space Complexity:    O(`totalRows`) + O(`totalCols`) ~ O(max(`totalRows`, `totalCols`))
 *
 * References:
 *  https://leetcode.com/problems/max-increase-to-keep-city-skyline/discuss/120681/C%2B%2BJavaPython-Easy-and-Concise-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0807

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val totalRows = grid.size
        val totalCols = grid[0].size

        val rowMaxes = IntArray(totalRows) { 0 }
        val colMaxes = IntArray(totalCols) { 0 }

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