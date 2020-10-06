package com.zea7ot.leetcode.lvl2.lc0463

class SolutionApproach0Geometry {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        // sanity check
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        val sizeRows = grid.size
        val sizeCols = grid[0].size

        var perimeter = 0
        for (row in 0 until sizeRows) {
            for (col in 0 until sizeCols) {
                if (grid[row][col] == 1) {
                    perimeter += 4
                    if (row > 0 && grid[row - 1][col] == 1) perimeter -= 2
                    if (col > 0 && grid[row][col - 1] == 1) perimeter -= 2
                }
            }
        }

        return perimeter
    }
}