package com.idiotleon.leetcode.lvl4.lc0305

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-islands-ii/
 *
 * Time Complexity:     O(`nPos`)
 * Space Complexity:    O(`m` * `n`) + O(`nPos`) / O(1) ~ O(`m` * `n`)
 */
@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int> {
        val nPos = positions.size
        val ans = MutableList(nPos) { 0 }

        val board = Array(m) { IntArray(n) { 0 } }

        val uf = UnionFind(board)

        for ((idx, pos) in positions.withIndex()) {
            val (row, col) = pos
            uf.addLand(row, col)
            ans[idx] = uf.getCount()
        }

        return ans
    }

    private class UnionFind(private val board: Array<IntArray>) {
        private val nRows = board.size
        private val nCols = board[0].size
        private val capacity = nRows * nCols

        private val roots = IntArray(capacity) { idx -> idx }
        private val ranks = IntArray(capacity) { 1 }

        private var isolated = 0

        fun getCount() = isolated

        fun addLand(row: Int, col: Int) {
            if (board[row][col] == 1) return
            board[row][col] = 1
            ++isolated

            for (d in 0 until 4) {
                val nextRow = row + DIRS[d]
                val nextCol = col + DIRS[d + 1]

                if (nextRow < 0 || nextRow >= nRows || nextCol < 0 || nextCol >= nCols || board[nextRow][nextCol] != 1) continue

                union(hash(row, col), hash(nextRow, nextCol))
            }
        }

        private fun hash(row: Int, col: Int) = row * nCols + col

        private fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX == rootY) return

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX
                ++ranks[rootX]
            } else {
                roots[rootY] = rootX
                ++ranks[rootY]
            }

            --isolated
        }

        private fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }
    }
}