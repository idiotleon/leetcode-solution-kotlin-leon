package com.an7one.leetcode.lvl4.lc1591

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/strange-printer-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/strange-printer-ii/discuss/854151/C%2B%2B-O(n3)-solution-checking-cycle-in-dependency-graph
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    private companion object {
        private const val RANGE_SIZE = 60 + 1
        private const val RANGE_VALUE = 60 + 1

        private const val NOT_VISITED = 0
        private const val VISITING = 1
        private const val VISITED = 2
    }

    fun isPrintable(targetGrid: Array<IntArray>): Boolean {
        val graph = buildGraph(targetGrid)

        val visited = IntArray(RANGE_SIZE) { NOT_VISITED }
        for (color in 1 until RANGE_VALUE) {
            if (visited[color] == NOT_VISITED && dfs(color, graph, visited)) return false
        }

        return true
    }

    // to detect any cycle
    private fun dfs(cur: Int, graph: List<List<Int>>, visited: IntArray): Boolean {
        visited[cur] = VISITING

        for (next in graph[cur]) {
            if (visited[next] == VISITED) continue
            if (visited[next] == VISITING) return true
            if (dfs(next, graph, visited)) return true
        }

        visited[cur] = VISITED
        return false
    }

    private fun buildGraph(grid: Array<IntArray>): List<List<Int>> {
        val graph = List(RANGE_SIZE) { mutableListOf<Int>() }

        for (color in 1 until RANGE_VALUE) {
            var minRow = RANGE_VALUE
            var minCol = RANGE_VALUE
            var maxRow = -RANGE_VALUE
            var maxCol = -RANGE_VALUE

            for (row in grid.indices) {
                for (col in grid[row].indices) {
                    if (grid[row][col] == color) {
                        minRow = minOf(minRow, row)
                        maxRow = maxOf(maxRow, row)
                        minCol = minOf(minCol, col)
                        maxCol = maxOf(maxCol, col)
                    }
                }
            }

            for (row in minRow..maxRow) {
                for (col in minCol..maxCol) {
                    if (grid[row][col] != color) {
                        graph[color].add(grid[row][col])
                    }
                }
            }
        }

        return graph
    }
}