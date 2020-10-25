/**
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/416227/Python-Dijkstra-Binary-Search-+-DFS-Union-Find-complexity-analysis/492501
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/416227/Python-Dijkstra-Binary-Search-%2B-DFS-Union-Find-complexity-analysis
 */
package com.zea7ot.leetcode.lvl4.lc1102

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearchWithDFS {
    private companion object {
        private val DIRS = arrayOf(0, -1, 0, 1, 0)
    }

    fun maximumMinimumPath(nums: Array<IntArray>): Int {
        val totalRows = nums.size
        val totalCols = nums[0].size

        val coordinates = ArrayList<Node>()
        for (row in 0 until totalRows) {
            for (col in 0 until totalCols) {
                if (nums[row][col] <= minOf(nums[0][0], nums[totalRows - 1][totalCols - 1])) {
                    coordinates.add(Node(row, col, nums[row][col]))
                }
            }
        }
        coordinates.sortBy { it.score }

        var lo = 0
        var hi = coordinates.size - 1
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (dfs(0, 0,
                            coordinates[mid].score,
                            Array(totalRows) { BooleanArray(totalCols) { false } },
                            nums)) {
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }

        return coordinates[hi].score
    }

    /**
     * to return whether it can reach the last or not
     */
    private fun dfs(row: Int, col: Int, min: Int,
                    seen: Array<BooleanArray>,
                    nums: Array<IntArray>): Boolean {
        val totalRows = nums.size
        val totalCols = nums[0].size

        if (row == totalRows - 1 && col == totalCols - 1) return true
        seen[row][col] = true

        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]

            if (nextRow in 0 until totalRows && nextCol in 0 until totalCols && !seen[nextRow][nextCol] && nums[nextRow][nextCol] >= min) {
                if (dfs(nextRow, nextCol, min, seen, nums)) return true
            }
        }

        return false
    }

    private data class Node(val row: Int, val col: Int, val score: Int)
}