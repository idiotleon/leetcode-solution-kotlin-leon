/**
 * https://leetcode.com/problems/bricks-falling-when-hit/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/bricks-falling-when-hit/discuss/195781/Union-find-Logical-Thinking
 */
package com.an7one.leetcode.lvl5.lc0803

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)

        private const val BRICK = 1
        private const val TO_HIT = 2
    }

    fun hitBricks(grid: Array<IntArray>, hits: Array<IntArray>): IntArray {
        val nRows = grid.size
        val nCols = grid[0].size
        val nHits = hits.size

        val uf = UnionFind(nRows * nCols + 1)

        for ((row, col) in hits) {
            if (grid[row][col] == BRICK) {
                grid[row][col] = TO_HIT
            }
        }

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == BRICK) {
                    unionSurrounding(row, col, grid, uf)
                }
            }
        }

        // the amount of bricks left after the last erasure
        var numBricksLeft = uf.getSize(0)
        // the index of the erasure
        var idx = nHits - 1
        // the amount of bricks that will drop after each erasure
        val nBricksDropped = IntArray(nHits) { 0 }

        while (idx >= 0) {
            val (row, col) = hits[idx]
            if (grid[row][col] == 2) {
                grid[row][col] = 1 // to restore to the last erasure
                unionSurrounding(row, col, grid, uf)
                val newNumBricksLeft = uf.getSize(0)
                nBricksDropped[idx] = maxOf(0, newNumBricksLeft - numBricksLeft - 1)
                numBricksLeft = newNumBricksLeft
            }

            --idx
        }

        return nBricksDropped
    }

    private fun unionSurrounding(row: Int, col: Int, grid: Array<IntArray>, uf: UnionFind) {
        val nRows = grid.size
        val nCols = grid[0].size

        val curHash = hash(row, col, nCols)

        for (d in 0 until 4) {
            val nextRow = row + DIRS[d]
            val nextCol = col + DIRS[d + 1]
            if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols || grid[nextRow][nextCol] != 1) continue
            uf.union(curHash, hash(nextRow, nextCol, nCols))
        }

        // to connect to the top of the grid
        if (row == 0) uf.union(0, curHash)
    }

    private fun hash(row: Int, col: Int, nCols: Int) = row * nCols + col + 1

    private class UnionFind(capacity: Int) {
        // 0 indicates the top of the grid
        val roots = IntArray(capacity) { idx -> idx }
        val sizes = IntArray(capacity) { 1 }

        fun getSize(x: Int): Int {
            val rootX = find(x)
            return sizes[rootX]
        }

        private fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)
            if (rootX == rootY) return

            if (sizes[rootX] > sizes[rootY]) {
                roots[rootY] = rootX
                sizes[rootX] += sizes[rootY]
            } else {
                roots[rootX] = rootY
                sizes[rootY] += sizes[rootX]
            }
        }
    }
}