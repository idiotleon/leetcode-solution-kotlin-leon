package com.an7one.leetcode.lvl4.lc1591

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/strange-printer-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/strange-printer-ii/discuss/854219/JavaTopological-Sort
 */
@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    private companion object {
        private const val RANGE_SIZE = 60 + 1
        private const val RANGE_VALUE = 60 + 1
    }

    fun isPrintable(targetGrid: Array<IntArray>): Boolean {
        val graph = List(RANGE_SIZE) { mutableListOf<Int>() }
        val indegrees = IntArray(RANGE_SIZE) { 0 }
        for (color in 1 until RANGE_VALUE) {
            search(color, indegrees, targetGrid, graph)
        }

        val queue = ArrayDeque<Int>().also {
            for (idx in indegrees.indices) {
                if (indegrees[idx] == 0) {
                    it.addLast(idx)
                }
            }
        }

        val seen = HashSet<Int>()

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (!seen.add(cur)) continue

            for (next in graph[cur]) {
                if (--indegrees[next] == 0) {
                    queue.addLast(next)
                }
            }
        }

        return seen.size == RANGE_VALUE
    }

    private fun search(color: Int, indegrees: IntArray, grid: Array<IntArray>, graph: List<MutableList<Int>>) {
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

        if (minRow == RANGE_VALUE) return

        for (row in minRow..maxRow) {
            for (col in minCol..maxCol) {
                if (grid[row][col] != color) {
                    graph[grid[row][col]].add(color)
                    ++indegrees[color]
                }
            }
        }
    }
}