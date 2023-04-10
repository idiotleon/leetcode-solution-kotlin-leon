/**
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 *
 * Time Complexity:     O(E * lg(V)) ~ O(`totalRows` * `totalCols` * lg(`totalRows` * `totalCols`))
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/
 *  https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/416227/Python-Dijkstra-Binary-Search-%2B-DFS-Union-Find-complexity-analysis
 *  https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/#:~:text=In%20the%20end%2C%20we%20end,2%20%2B%203%20%2B%205).&text=Time%20Complexity%3A,Time%20Complexity%20of%20the%20algorithm.
 */
package com.idiotleon.leetcode.lvl4.lc1102

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0KruskalMST1 {
    private companion object {
        private val DIRS = arrayOf(0, -1, 0, 1, 0)
    }

    fun maximumMinimumPath(nums: Array<IntArray>): Int {
        val totalRows = nums.size
        val totalCols = nums[0].size

        val maxHeap = PriorityQueue<IntArray>(compareBy { -nums[it[0]][it[1]] })
        for (row in 0 until totalRows) {
            for (col in 0 until totalCols) {
                maxHeap.add(intArrayOf(row, col))
            }
        }

        val uf = UnionFind(totalRows * totalCols)
        val seen = Array(totalRows) { BooleanArray(totalCols) { false } }

        while (maxHeap.isNotEmpty()) {
            val cur = maxHeap.poll()
            val row = cur[0]
            val col = cur[1]
            seen[row][col] = true

            for (d in 0 until 4) {
                val nextRow = row + DIRS[d]
                val nextCol = col + DIRS[d + 1]

                if (nextRow in 0 until totalRows && nextCol in 0 until totalCols && seen[nextRow][nextCol]) {
                    uf.union(row * totalCols + col, nextRow * totalCols + nextCol)
                }

                if (uf.find(0) == uf.find(totalRows * totalCols - 1)) return nums[row][col]
            }
        }

        return -1
    }

    private class UnionFind(capacity: Int) {
        private val roots = IntArray(capacity) { idx -> idx }
        private val ranks = IntArray(capacity) { 1 }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX
                ++ranks[rootX]
            } else {
                roots[rootX] = rootY
                ++ranks[rootY]
            }
        }

        fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }
    }
}