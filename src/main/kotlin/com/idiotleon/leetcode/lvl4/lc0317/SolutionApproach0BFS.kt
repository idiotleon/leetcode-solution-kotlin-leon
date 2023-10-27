package com.idiotleon.leetcode.lvl4.lc0317

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 *
 * Time Complexity:     O(`nBuildings` * `nRows` * `nCols`) ~ O((`nRows` * `nCols`) ^ 2)
 * Space Complexity:    O(`nRows` * `nCols`) + O(`nBuildings`) ~ O(`nRows` * `nCols`)
 *
 * Reference:
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76886/Share-a-Java-implement
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun shortestDistance(grid: Array<IntArray>): Int {
        val nRows = grid.size
        val nCols = grid[0].size

        val buildings = mutableListOf<Building>()

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == Type.BUILDING.code) {
                    buildings.add(Building(row, col, 0))
                }

                grid[row][col] = -grid[row][col]
            }
        }

        val nBuildings = buildings.size
        val distances = Array(nRows) { IntArray(nCols) { 0 } }
        for ((idx, building) in buildings.withIndex()) {
            bfs(building, idx, distances, grid)
        }

        var shortest = -1
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == nBuildings && (shortest < 0 || shortest > distances[row][col])) {
                    shortest = distances[row][col]
                }
            }
        }

        return shortest
    }

    private fun bfs(building: Building, expectedId: Int, distances: Array<IntArray>, grid: Array<IntArray>) {
        val nRows = grid.size
        val nCols = grid[0].size

        val queue = ArrayDeque<Building>().also {
            it.addLast(building)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val (row, col, distance) = queue.removeFirst()
                distances[row][col] += distance

                for (d in 0 until 4) {
                    val nextRow = row + DIRS[d]
                    val nextCol = col + DIRS[d + 1]
                    if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols || grid[nextRow][nextCol] != expectedId) {
                        continue
                    }

                    grid[nextRow][nextCol] = 1 + expectedId
                    queue.addLast(Building(nextRow, nextCol, 1 + distance))
                }
            }
        }
    }

    private data class Building(val row: Int, val col: Int, val distance: Int)

    private enum class Type(val code: Int) {
        EMPTY(0), BUILDING(1), OBSTACLE(2)
    }
}