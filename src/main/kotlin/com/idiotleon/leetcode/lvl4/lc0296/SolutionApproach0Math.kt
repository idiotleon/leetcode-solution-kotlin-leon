package com.idiotleon.leetcode.lvl4.lc0296

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/best-meeting-point/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * Reference:
 * https://leetcode.com/problems/best-meeting-point/discuss/74186/14ms-java-solution/77254
 * https://leetcode.com/problems/best-meeting-point/discuss/74186/14ms-java-solution
 * https://leetcode.com/problems/best-meeting-point/discuss/74217/The-theory-behind-(why-the-median-works)
 * https://en.wikipedia.org/wiki/Geometric_median
 */
@Suppress(UNUSED)
class SolutionApproach0Math {
    fun minTotalDistance(grid: Array<IntArray>): Int {
        // not used
        // val nRows = grid.size
        // val nCols = grid[0].size

        val rows = mutableListOf<Int>()
        val cols = mutableListOf<Int>()

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    rows.add(row)
                }
            }
        }

        for (col in grid[0].indices) {
            for (row in grid.indices) {
                if (grid[row][col] == 1) {
                    cols.add(col)
                }
            }
        }

        return getMinDistance(rows) + getMinDistance(cols)
    }

    private fun getMinDistance(grid: List<Int>): Int {
        var sum = 0
        var lo = 0
        var hi = grid.lastIndex

        while (lo < hi) {
            sum += grid[hi--] - grid[lo++]
        }

        return sum
    }
}