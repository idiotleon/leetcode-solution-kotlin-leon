/**
 * https://leetcode.com/problems/best-meeting-point/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * References:
 *  https://leetcode.com/problems/best-meeting-point/discuss/74186/14ms-java-solution
 *  https://leetcode.com/problems/best-meeting-point/discuss/74217/The-theory-behind-(why-the-median-works)
 *  https://en.wikipedia.org/wiki/Geometric_median
 */
package com.zea7ot.leetcode.lvl4.lc0296

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math1 {
    fun minTotalDistance(grid: Array<IntArray>): Int {
        val rows = mutableListOf<Int>()
        val cols = mutableListOf<Int>()

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    rows.add(row)
                    cols.add(col)
                }
            }
        }

        return getMinDistance(rows) + getMinDistance(cols)
    }

    private fun getMinDistance(list: MutableList<Int>): Int {
        list.sort()

        var sum = 0
        var lo = 0
        var hi = list.lastIndex

        while (lo < hi) {
            sum += list[hi--] - list[lo++]
        }

        return sum
    }
}