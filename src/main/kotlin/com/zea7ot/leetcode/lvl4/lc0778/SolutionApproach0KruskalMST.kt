/**
 * https://leetcode.com/problems/swim-in-rising-water/
 *
 * Time Complexity:     O(E * lg(V)) ~ O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/swim-in-rising-water/discuss/118204/Java-DFS-and-Union-Find/309165
 */
package com.zea7ot.leetcode.lvl4.lc0778

class SolutionApproach0KruskalMST {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val uf = UnionFind(n)

        val map = IntArray(n * n) { 0 }
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                map[grid[row][col]] = hash(row, col, n)
            }
        }

        for (time in 0 until n * n) {
            val idx = map[time]
            val curRow = idx / n
            val curCol = idx % n

            for (d in 0 until 4) {
                val nextRow = curRow + DIRS[d]
                val nextCol = curCol + DIRS[d + 1]

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] > time) continue

                uf.union(hash(curRow, curCol, n), hash(nextRow, nextCol, n))
            }

            if (uf.find(hash(0, 0, n)) == uf.find(hash(n - 1, n - 1, n)))
                return time
        }

        return -1
    }

    private fun hash(row: Int, col: Int, n: Int) = row * n + col

    private class UnionFind(n: Int) {
        private val roots = IntArray(n * n) { idx -> idx }
        private val ranks = IntArray(n * n) { 1 }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX == rootY) return
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