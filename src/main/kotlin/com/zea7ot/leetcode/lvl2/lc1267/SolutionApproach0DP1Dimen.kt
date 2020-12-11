/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` + `nCols`) ~ O(max(`nRows`, `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/count-servers-that-communicate/discuss/436130/C%2B%2B-Simple-Preprocessing
 *
 */
package com.zea7ot.leetcode.lvl2.lc1267

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun countServers(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val rowCounts = IntArray(nRows) { 0 }
        val colCounts = IntArray(nCols) { 0 }

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    ++rowCounts[row]
                    ++colCounts[col]
                }
            }
        }

        var count = 0
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1 && (rowCounts[row] > 1 || colCounts[col] > 1)) {
                    ++count
                }
            }
        }

        return count
    }
}